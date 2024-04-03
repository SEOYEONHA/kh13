package com.kh.spring10.service;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring10.dao.CertDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.CertDto;
import com.kh.spring10.dto.MemberDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSenderImpl sender;
	
	@Autowired
	private MemberDao memberDao;
	
	//가입 환영 이메일 발송
	public void sendWelcomeMail(String email) {
		SimpleMailMessage message = new SimpleMailMessage();	
		message.setTo(email);
		message.setSubject("[KH정보교육원] 가입을 환영합니다");
		message.setText("앞으로 많은 활동 부탁드립니다!");
		
		sender.send(message);
	}
	
	public void sendWelcomeMail(MemberDto memberDto) throws IOException, MessagingException {
		ClassPathResource resource = new ClassPathResource("templates/welcome-template.html");
		File target = resource.getFile();
		
		StringBuffer buffer = new StringBuffer();
		Scanner sc = new Scanner(target);
		while(sc.hasNextLine()) {
			buffer.append(sc.nextLine());
		}
		sc.close();
		
		Document document = Jsoup.parse(buffer.toString());
		Element who = document.getElementById("who");
		who.text(memberDto.getMemberNick());
		
		Element link = document.getElementById("login-link");
		//link.attr("href", "로그인페이지주소");
		//link.attr("href", "http://localhost:8080/member/login");//서버PC에서만
		//link.attr("href", "http://192.168.30.200:8080/member/login");//강의장에서만(같은 인터넷 공유기 IP를 공유하는 곳에서만)
		
		//주소를 상황에 맞게 생성하는 도구 - ServletUriComponentsBuilder
		//이메일에 우리 사이트 링크를 걸고싶을때 링크 전체를 적는것보다 이런식으로 자동으로 하는게 좋음
		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
																	.path("/member/login")
																	.build().toUriString();
		
		//url이라는 변수 안만들고 그냥 바로 넣어도 좋지만 가독성을 위해 한 것 ...
		link.attr("href", url); 
		
		Element image = document.getElementById("background-img");
		image.attr("src", ServletUriComponentsBuilder.fromCurrentContextPath()
																.path("/image/mailTest.jpg")
																.build().toUriString());
		
		
		//마임메세지 생성
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(memberDto.getMemberEmail());
		helper.setSubject("[KH정보교육원] 가입을 환영합니다");
		helper.setText(document.toString(), true);
		
		sender.send(message);
	}
	
	//아이디 찾기 -> 아이디 발송
	public boolean sendMemberId(String memberNick) {
		MemberDto memberDto = memberDao.selectOneByMemberNick(memberNick);
		
		if(memberDto != null) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(memberDto.getMemberEmail());
			message.setSubject("[KH정보교육원] 아이디 찾기 결과 안내");
			message.setText("당신의 아이디는 " + memberDto.getMemberId() + "입니다");
			
			sender.send(message);
			return true;
		}
		
		else { //존재하지 않는 닉네임이라면
			return false;
		}
	}
	
	//임시 비밀번호 발송
	public void sendTempPassword(MemberDto memberDto) {
		String lower = "abcdefghijklmnopqrstuvwxyz"; //3글자
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //3글자
		String number = "0123456789"; //1글자
		String special = "!@#$"; //1글자
		
		Random r = new Random(); //랜덤 도구
		StringBuffer buffer = new StringBuffer(); //문자열 합성도구
		
		for(int i = 0 ; i < 3 ; i ++){
			int pos = r.nextInt(lower.length())/* +0 */; //lower에서의 랜덤위치
			buffer.append(lower.charAt(pos)); //버퍼에 추가
		}
		for(int i = 0 ; i < 3 ; i ++){
			int pos = r.nextInt(upper.length()); //upper에서의 랜덤위치
			buffer.append(upper.charAt(pos)); //버퍼에 추가
		}
		for(int i = 0 ; i < 1 ; i ++){ //1글자만 뽑을거긴 하지만 추후 뽑을 개수변경 쉽게하기 위해 반복문으로
			int pos = r.nextInt(number.length()); //number에서의 랜덤위치
			buffer.append(number.charAt(pos)); //버퍼에 추가
		}
		for(int i = 0 ; i < 1 ; i ++){
			int pos = r.nextInt(special.length()); //special에서의 랜덤위치
			buffer.append(special.charAt(pos)); //버퍼에 추가
		}
		
		//생성한 비밀번호로 DB를 변경
		memberDto.setMemberPw(buffer.toString()); //비밀번호 설정 후
		memberDao.updateMemberPw(memberDto); //변경처리
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(memberDto.getMemberEmail());
		message.setSubject("[KH정보교육원] 임시 비밀번호 안내");
		message.setText("임시 비밀번호는 " + memberDto.getMemberPw() + "입니다");
		
//		MemberDto findDto = memberDao.selectOne(memberId);
		
//		memberDto.setMemberPw(buffer.toString());
		
		sender.send(message);
	}
	
	@Autowired
	private CertDao certDao;
	
	//인증번호 발송 - 주어진 이메일에 무작위 6자리 숫자를 전송
	public void sendCert(String memberEmail) {
		Random r = new Random();
		int number = r.nextInt(1000000); //000000~999999
		DecimalFormat fmt = new DecimalFormat("000000");
		
		//메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(memberEmail);
		message.setSubject("[KH정보교육원] 인증번호 안내");
		message.setText("인증번호는 [" + fmt.format(number) + "] 입니다");
		
		sender.send(message);
		
		//인증번호 저장 - 기존 내역 삭제 후 저장
		certDao.delete(memberEmail);
		CertDto certDto = new CertDto();
		certDto.setCertEmail(memberEmail);
		certDto.setCertNumber(fmt.format(number));
		certDao.insert(certDto);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
