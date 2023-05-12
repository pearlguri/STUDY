package com.yedam.oop;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {

		// 1
		int a = 10;
		double b = 2.0;

		double sum = a + b;
		double minus = a - b;
		double multiply = a * b;
		double divide = a / b;

		System.out.println(sum);
		System.out.println(minus);
		System.out.println(multiply);
		System.out.println(divide);

		// 2

		// (1) F
		// (2) T
		// (3) F

		// 3
		// 큰 금액부터 동전을 우선적으로 거슬러 줘야한다.
		// 출력 예시) 500원 : 5개, 100원 : 1개, 50원 : 1개, 10원 : 3개
		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;
		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			if (money / coinUnit[i] > 0) {
				System.out.println(coinUnit[i] + "원 : " + money / coinUnit[i] + "개");
				money %= coinUnit[i];
			}
		}

		// 4
		for (int i = 2; i <= 9; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.println(i + "*" + k + "=" + (i * k));
			}
		}

		// 5
		Scanner sc = new Scanner(System.in);
		int diceNo = 0;
		int[] dice = null;
		int selectNo = 0;

		while (selectNo != 5) {
			System.out.println("===1.주사위 크기 |2.주사위 굴리기 |3. 결과 보기 |4. 가장 많이 나온 수 |5. 종료 ===");
			System.out.println("메뉴 >");

			selectNo = Integer.parseInt(sc.nextLine());
			switch (selectNo) {
			case 1:
				System.out.println("주사위 크기>");
				diceNo = Integer.parseInt(sc.nextLine());
				if (diceNo < 5 || diceNo > 10) {
					System.out.println("주사위의 범위는 5 ~ 10입니다.");
					// 2번 주사위 굴리기 할 때 활용
					diceNo = 0;
				}
				break;
			case 2:
				// 만약 주사위 크기가 제대로 입력되지 않았다면??
				if (diceNo == 0) {
					System.out.println("주사위 번호가 제대로 입력되지 않음.");
					System.out.println("다시 입력하세요.");
				} else {
					// 주사위 배열 생성
					dice = new int[diceNo];
					// 주사위를 굴린 횟수
					int count = 0;
					while (true) {
						// 주사위 굴린 횟수 증가
						count++;
						// 랜덤값 -> 주사위를 굴려서 나오는 값
						int randomDice = (int) (Math.random() * diceNo) + 1;
						// 랜덤값을 활용하여 dice배열의 인덱스를 구한 뒤 1씩 증가
						dice[randomDice - 1]++;
						if (randomDice == 5) {
							System.out.println("5가 나올 때까지 " + count + "번 굴렸습니다.");
							break;
						}
					}

				}
				break;
			case 3:
				for (int i = 0; i < dice.length; i++) {
					System.out.println((i + 1) + "은 " + dice[i] + "번 나왔습니다.");
				}
				break;
			case 4:
				//가장 많이 나온 수가 여러 개일 경우 가장 작은 수가 출력
				int max = dice[dice.length - 1];
				int idx = 0;
				for (int i = dice.length - 2; i >= 0; i--) {
					if (max < dice[i]) {
						max = dice[i];
						idx = i + 1;
					}
				}
				System.out.println("가장 많이 나온 수는 " + idx + "입니다.");
				break;
			case 5:
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
