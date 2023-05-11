package com.yedam.oop;

public class Book {
	// Book이라는 클래스는 아래의 정보를 가진다.
	// 책이름, 책종류, 가격, 도서번호, 출판사
	String name;
	String kind;
	String price;
	String number;
	String pub;

	// 생성자는 2개
	// 기본 생성자
	Book() {

	}

	// 모든 데이터를 받아오는 생성자
	Book(String name, String kind, String price, String number, String pub) {
		this.name = name;
		this.kind = kind;
		this.price = price;
		this.number = number;
		this.pub = pub;
	}

	// 메소드
	// 모든 정보를 출력할 수 있는 getInfo()

	void getInfo() {
		System.out.println("책이름 : " + name + "\n" + "# 내용" + "\n" + "1) 종류 : " + kind + " 2) 가격 : " + price + "원 "
				+ "3) 출판사 : " + pub + " 4) 도서번호 : " + number);
	}

	// 객체 생성할 때, 생성자를 통한 필드 초기화
	// 다음과 같은 출력물이 나오도록 구현
	// 객체.getInfo()
	// 책 이름 : 혼자 공부하는 자바
	// # 내용
	// 1) 종류 : 학습서
	// 2) 가격 : 24000원
	// 3) 출판사 : 한빛 미디어
	// 4) 도서번호 : 0001

	// 책 이름 : 둘이 공부하는 자바
	// # 내용
	// 1) 종류 : 학습서
	// 2) 가격 : 15000원
	// 3) 출판사 : 두빛 미디어
	// 4) 도서번호 : 0002
}
