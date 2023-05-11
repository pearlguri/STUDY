package com.yedam.Print;

import java.io.IOException;
import java.util.Scanner;

public class KeyCode {
	public static void main(String[] args) throws IOException{
		//KeyCode -> 하나의 문자만 받아 올 때
		System.out.println("입력>");
		
		int KeyCode = 0;
		
		KeyCode = System.in.read();
		System.out.println("KeyCode : " + KeyCode);
		
		KeyCode = System.in.read();
		System.out.println("KeyCode : " + KeyCode);
		
		KeyCode = System.in.read();
		System.out.println("KeyCode : " + KeyCode);
		
		
		//Scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력>");
		
		
		//문자열 읽기
		//nextLine()
		//=> enter키 이전까지 데이터를 받아 옴.
		//=> enter키 기준으로 데이터를 읽어 옴.
		String inputData = scanner.nextLine();
		//정수 읽기
		int data = scanner.nextInt();
		//엔터키 소멸
		scanner.nextLine();
		
		inputData = scanner.nextLine();
		System.out.println("Scanner 활용 => "+ inputData);
		
		//데이터 비교 -> 입력한 값 == 저장된 값 비교
		
		//기본 타입(정수, 실수 비교 ==)
		//문자열 -> equals
		if(inputData.equals("yedam")) {
			System.out.println("yedam과 일치합니다.");
		}
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
