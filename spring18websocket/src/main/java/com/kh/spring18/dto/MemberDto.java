package com.kh.spring18.dto;

import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"memberPw"})
public class MemberDto {
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberBirth;
	private String memberContact;
	private String memberEmail;
	private String memberPost;
	private String memberAddress1;
	private String memberAddress2;
	private String memberLevel;
	private int memberPoint;
	private Date memberJoin;
	private Date memberLogin;
	
	//객체 하나 만들어서 값이 null일 때 출력이 null이 아니라 빈칸으로 만들어주는.
	public String getMemberBirthStr() {
		if(memberBirth == null)
			return "";
		else 
			return memberBirth;
	}
	
	public String getMemberContactStr() {
		if(memberContact == null)
			return "";
		else
			return memberContact;
	}
	
	public String getMemberPostStr() {
		if(memberPost == null)
			return "";
		else 
			return memberPost;
	}

	public String getMemberAddress1Str() {
		if(memberAddress1 == null)
			return "";
		else
			return memberAddress1;
	}
	
	public String getMemberAddress2Str() {
		if(memberAddress2 == null)
			return "";
		else
			return memberAddress1;
	}
	
	public String getMemberLoginStr() {
		if(memberLogin == null)
			return "";
		else
			return memberLogin.toString();
	}
	
	
}
