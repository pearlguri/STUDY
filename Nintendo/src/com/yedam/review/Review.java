package com.yedam.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
//	REVIEW_ID NOT NULL VARCHAR2(20)  
//	MEMBER_ID          VARCHAR2(20)  
//	TEXT               VARCHAR2(300) 
//	GAME_ID            VARCHAR2(20) 
	
	private String reviewId;
	private String memberId;
	private String text;
	private String gameId;
}
