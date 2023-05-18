package com.yedam.student;

public class Student {
//	STD_ID    NOT NULL NUMBER       
//	STD_NAME  NOT NULL VARCHAR2(9)  
//	STD_MAJOR          VARCHAR2(18) 
//	STD_POINT          NUMBER  
	
	private int stdId;
	private String stdName;
	private String stdMajor;
	private int stdPoint;
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdMajor() {
		return stdMajor;
	}
	public void setStdMajor(String stdMajor) {
		this.stdMajor = stdMajor;
	}
	public int getStdPoint() {
		return stdPoint;
	}
	public void setStdPoint(int stdPoint) {
		this.stdPoint = stdPoint;
	}
	
	
}
