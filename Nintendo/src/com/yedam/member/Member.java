package com.yedam.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
//	MEMBER_ID    NOT NULL VARCHAR2(20) 
//	MEMBER_PW             VARCHAR2(20) 
//	MEMBER_NAME           VARCHAR2(20) 
//	MEMBER_PHONE          VARCHAR2(13) 
//	MEMBER_GRADE          CHAR(1)   
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberGrade;
	private Date start;
	private Date end;
}
