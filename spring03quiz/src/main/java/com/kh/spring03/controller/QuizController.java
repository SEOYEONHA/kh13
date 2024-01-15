package com.kh.spring03.controller;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

///dice : 랜덤으로 주사위 번호 1개를 출력
///lotto : 랜덤으로 로또번호 6개를 출력
///food : 랜덤으로 본인이 원하는 식사메뉴 중 하나를 출력

//스프링의 1원칙 : 무조건 등록부터해라(IoC, 제어반전)
@RestController
public class QuizController {
	Random r = new Random();
	
	@RequestMapping("/dice")
	public String dice() {
		int dice = r.nextInt(6) + 1;
		return "주사위 번호 : " + dice;
	}
	
	@RequestMapping("/lotto")
//	public String lotto() {
//		ArrayList<Integer> lotto = new ArrayList<>();
//		for(int i = 1 ; i <= 6 ; i++) {
//			int lottoNum = r.nextInt(45) + 1;
//				if(!lotto.contains(lottoNum)){
//					lotto.add(lottoNum);
//					}
//				else {
//					i--;
//				}
//			}
//			return "로또 번호 : " + lotto;
//		}
	public String lotto() {
		Random r = new Random();
		Set<Integer> lottoNumbers = new TreeSet<>();
		while(lottoNumbers.size() < 6) {
			lottoNumbers.add(r.nextInt(45) + 1);
		}
		return "로또번호 : " + lottoNumbers;
	}
	
	@RequestMapping("/food")
	public String food() {
		String[] foodList = new String[] {"라면", "김밥", "국밥", "치킨", "피자", "파스타", 
									"곱창", "삼겹살", "짜장면", "짬뽕"};
		int choice = r.nextInt(foodList.length);
		
		return "추천 메뉴 : " + foodList[choice];
	}
}