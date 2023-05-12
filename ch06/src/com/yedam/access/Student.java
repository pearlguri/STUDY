package com.yedam.access;

public class Student {
	/*
	 * 이름, 학과, 학년, 과목별 점수 과목 -> programming, database, os 필드들은 모두 private setter
	 * 메소드를 활용해서 필드 초기화 getter 메소드를 활용해서 객체의 필드 reading getInfo() 학생의 정보 출력
	 */

	// 필드
	private String stdName;
	private String major;
	private String stdGrade;
	private int programming;
	private int database;
	private int os;

	// 생성자(기본 생성자)

	// 메소드
	public void setStdName(String stdName) { // 데이터 입력 (=객체.필드명 = ' ';)
		this.stdName = stdName;
	}

	public String getStdName() { // 데이터 읽기 (=객체.필드명;)
		return stdName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStdGrade() {
		return stdGrade;
	}

	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}

	public int getProgramming() {
		return programming;
	}

	// 과목의 점수입력
	// 프로그래밍 점수가 0점보다 낮은 점수(음수)가 입력될 경우에는
	// 프로그래밍 점수를 0점으로 하겠다.
	public void setProgramming(int programming) {
//		if (programming < 0) {
//			this.programming = 0;
//			return; // 메소드 강제 종료
//		}
//		this.programming = programming;

		// 삼항 연산자
		this.programming = (programming < 0) ? 0 : programming;
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public int getOs() {
		return os;
	}

	public void setOs(int os) {
		this.os = os;
	}

}
