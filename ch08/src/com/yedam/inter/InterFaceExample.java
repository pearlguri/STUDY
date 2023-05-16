package com.yedam.inter;

public class InterFaceExample {
	public static void main(String[] args) {
		// 인터페이스는 스스로 객체X
		// 구현 클래스의 도움을 받아야 함.
		RemoteControl rc = new Television();

		rc.turnOn();
		rc.setVoulume(5);
		rc.setVoulume(12);
		rc.setVoulume(-50);
		rc.turnOff();

		rc.search("www.google.com");
		
//		rc = new Audio();
//
//		rc.turnOn();
//		rc.setVoulume(3);
//		rc.setVoulume(-1);
//		rc.turnOff();

		Searchable rc2 = new Television();
		rc2.search("www.naver.com");
		
		InterfaceC ic = new ImplementsC();
		ic.method1();
		ic.method2();
		ic.method3();

	}
}
