package com.yedam.oop;

public class Student {
	//학생의 정보를 관리하는 프로그램
			//학생의 정보를 관리하는 객체
			//이름, 학년, 국어, 영어, 수학
			String name;
			String grade;
			int lang;
			int eng;
			int math;
			
			//기본 생성자
			Student(){
				
			}
			
			Student(String name, String grade, int lang, int eng, int math){
				this.name = name;
				this.grade = grade;
				this.lang = lang;
				this.eng = eng;
				this.math = math;
			}
			//메소드
			//모든 정보를 출력 getInfo()
			
			void getInfo() {
				System.out.println("학생명 : " + name + "\n "
						+ "학년 : " + grade + "\n "
						+ "국어점수 : " + lang + "\n "
						+ "영어점수 : " + eng + "\n "
						+ "수학점수 : " + math);
			}
			
			//1.학생수
			//2.정보입력
			//3.정보확인
			//4.분석 - 전체 학생의 점수 총합(국+영+수)
			//		- 총합의 평균
			//		- 개인별 가장 점수가 높은 과목 / 낮은 과목
			//5.종료
}
