package com.yedam.account;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


//@Data
@Getter
@Setter
public class Account {
//	ACCOUNT_ID      NOT NULL VARCHAR2(20)      
//	ACCOUNT_BALANCE          NUMBER       
//	ACCOUNT_CREDATE          DATE         
//	MEMBER_ID                VARCHAR2(20) 
	
	private String accountId;
	private int accountBalance;
	private Date accountCredate;
	private String memberId;
}
