package com.kh.spring19.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
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
}
