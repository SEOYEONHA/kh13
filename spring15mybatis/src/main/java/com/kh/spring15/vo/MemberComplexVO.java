package com.kh.spring15.vo;

import java.util.List;

import lombok.Data;

@Data
public class MemberComplexVO {
	private String memberId;
	private String memberNick;
	private String memberContact;
	private Integer minPoint, maxPoint; //null일수도있기 때문에 int아니고 Integer!!
	private String memberJoin;
	private String minLoginDate, maxLoginDate;
	private List<String> memberLevelList;
	private List<String> orderList;
	private Integer beginRow, endRow;
}
