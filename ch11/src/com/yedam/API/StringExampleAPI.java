package com.yedam.API;

import java.util.Scanner;

public class StringExampleAPI {
	public static void main(String[] args) {
		// 1) 문자열 뒤집기
		// String str = "abcdefg" -> "gfedcba"
		String str = "abcdefg";
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}

		// 2) 문자 개수 찾기
		// String str = "1n2ASD 330naa1"
		// 숫자 : 6개, 알파벳 : 7개, 공백 : 1
		String str2 = "1n2ASD 30naa1";
		int alpha = 0, num = 0, space = 0;
		for (int i = 0; i < str.length(); i++) {
			// 문자열 읽기
			char tempCh = str.charAt(i);
			if (tempCh == ' ') {
				space++; // 공백 개수 증가
			} else if (tempCh >= '0' && tempCh <= '9') {
				num++; // 숫자 개수 증가
			} else if (tempCh >= 'A' && tempCh <= 'Z' || tempCh >= 'a' && tempCh <= 'z') {
				alpha++; // 알파벳 개수 증가
			}
		}
		System.out.println("숫자 : " + num + "개" + "알파벳 : " + alpha + "개 " + "공백(띄워쓰기) : " + space + "개");

		// 3)주민등록번호 입력 후 나이 계산하기
		// 단, 올해 기준 00 ~ 23년생 -> 21세기, 24 ~ 99년생 -> 20세기
		// String ssn = "980102-1234567"
		// 나이 : 26
		// 1922년 이후 2000년 이전 출생 -> 98+26=124
		// String ssn = "000102-1234567"
		// 나이 : 24
		// 2000년 이후 2023년 이전 출생 -> 00+24=24
		Scanner sc = new Scanner(System.in);
		System.out.println("생년월일>");
		String birth = sc.nextLine();
		// 년도를 문자열을 자르고 정수로 변환
		int birthNo = Integer.parseInt(birth.substring(0, 2));

		if (birthNo <= 23) {
			System.out.println("나이 : " + (24 - birthNo) + "살");
		} else {
			System.out.println("나이 : " + (124 - birthNo) + "살");
		}

		// 4)문자열 개수 파악 or 압축
		// String str = "KKHSSSSSSSSE"
		// 결과 -> K2HS8E
		String str3 = "KKHSSSSSSSSE";
		String result = "";
		int count = 1;
		for (int i = 0; i < str3.length(); i++) {
			// 문자 비교
			if (i < str3.length() - 1 && str3.charAt(i) == str3.charAt(i + 1)) {
				count++;
			} else {
				result += str3.charAt(i);
				if (count > 1) {
					result += String.valueOf(count);
				}
				count = 1;
			}
		}
		System.out.println(result);
	}
}
