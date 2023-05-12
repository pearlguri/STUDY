package com.yedam.access;

import java.util.Scanner;

public class Application02 {
	public static void main(String[] args) {
		//인스턴스(객체) 생성
		Student std = new Student();
		//인스턴스 필드 -> 데이터 입력 및 저장
		std.setStdName("김또치");
		std.setMajor("컴퓨터공학과");
		std.setStdGrade("2학년");
		std.setProgramming(-5);
		std.setDatabase(50);
		std.setOs(-50);
		//인스턴스 필드 -> 데이터 얻기 및 읽기
		System.out.println("이름 : " + std.getStdName());
		System.out.println("전공 : " + std.getMajor());
		System.out.println("학년 : " + std.getStdGrade());
		System.out.println("프로그래밍 : " + std.getProgramming());
		System.out.println("데이터베이스 : " + std.getDatabase());
		System.out.println("운영체제 : " + std.getOs());
		
		
	Member member = new Member();
	
	//인스턴스 필드 -> 데이터 입력
	
	member.setId("yedam");
	member.setPassword("1234");
	member.setName("도우너");
	member.setAge(-100);
	
	//데이터 얻기 & 읽기
	System.out.println(member.getId());
	System.out.println(member.getPassword());
	System.out.println(member.getName());
	System.out.println(member.getAge());
	
	
	
	
	
	
	
	
	
	
		
	}
}
