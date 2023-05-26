package com.yedam.game;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
//	GAME_ID           NOT NULL VARCHAR2(20) 
//	GAME_NAME                  VARCHAR2(40) 
//	GAME_RENTAL_START          DATE         
//	GAME_RENTAL_END            DATE         
//	GAME_STATUS                CHAR(1)      
//	MEMBER_ID                  VARCHAR2(20) 
//	G_NUM                      NUMBER       

	private String gameId;
	private String gameName;
	private Date start;
	private Date end;
	private String gameStatus;
	private String memberId;
	private String left;
	private int gNum;
}
