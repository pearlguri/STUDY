package co.micol.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
//	NOTICE_ID      NOT NULL NUMBER         
//	NOTICE_WRITER  NOT NULL VARCHAR2(50)   
//	NOTICE_TITLE   NOT NULL VARCHAR2(200)  
//	NOTICE_SUBJECT          VARCHAR2(4000) 
//	NOTICE_WDATE   NOT NULL DATE           
//	NOTICE_HIT              NUMBER  

	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeWdate;
	private int noticeHit;
}
