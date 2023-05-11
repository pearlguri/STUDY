package com.yedam.condition;

import java.util.Scanner;

public class SwitchCondition {


	public static void main(String[] args) {
		int number = (int) (Math.random() * 6) + 1;

		switch (number) {
		case 1:
			System.out.println("주사위 번호1");
			break;
		case 2:
			System.out.println("주사위 번호2");
			break;
		case 3:
			System.out.println("주사위 번호3");
			break;
		case 4:
			System.out.println("주사위 번호4");
			break;
		case 5:
			System.out.println("주사위 번호5");
			break;
		default:
			System.out.println("주사위 번호6");
			break;
		}

		// char
		char grade = 'B';
		String grade2 = "b";

		switch (grade) {
		case 'A':
			System.out.println("우수 회원");
			break;
		case 'B':
			System.out.println("일반 회원");
			break;
		default:
			System.out.println("손님");
			break;
		}
		switch (grade2) {
		case "a":
			System.out.println("우수 회원");
			break;
		case "B":
		case "b":
			System.out.println("일반 회원");
			break;
		default:
			System.out.println("손님");
			break;

		}

		// 입력한 성적을 등급으로 표현
		Scanner sc = new Scanner(System.in);

		System.out.println("성적입력>");

		// 주: switch 부: if
		// 0~100
		// 90 이상 A -> 95 이상 A+ | 90 이하 A
		// 80 이상 B -> 90~85 B+ | 80~ 84 B
		// 70 이상 C -> 80~75 C+ | 70~74 C
		// 그 이하는 D
		//
	
		int scores = Integer.parseInt(sc.nextLine());

		switch(scores/10) {
		case 9: //99~90/10 => 9
			if(scores>=95) {
				System.out.println("A+");
			}else {
				System.out.println("A");
			}
			break;
		case 8: //88~80/10 => 8
			if(scores>=85) {
				System.out.println("B+");
			}else {
				System.out.println("B");
			}
			break;
		case 7:
			if(scores>=75) {
				System.out.println("C+");
			}else {
				System.out.println("C");
			}
			break;
		default:			
				System.out.println("D");
			break;
			
		}
		
		//메뉴 선택
		System.out.println("1. 글보기 2. 글 수정 3. 글 삭제 4. 뒤로 가기");
		int selectNo = Integer.parseInt(sc.nextLine());
		
		switch(selectNo) {
		case 1:
			System.out.println("1번 선택");
			System.out.println("글 보는 기능");
			break;
		case 2:
			System.out.println("글 수정하는 기능");
			break;
		case 3:
			System.out.println("글 삭제하는 기능");
			break;
		case 4:
			System.out.println("뒤로 가기");
			break;
			
		}
		
		
		

	}
}
