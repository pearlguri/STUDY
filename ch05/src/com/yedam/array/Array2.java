package com.yedam.array;

import java.util.Scanner;

public class Array2 {

	public static void main(String[] args) {
		int[] intAry = new int[10];

		System.out.println("intAry의 길이: " + intAry.length);

//		for(int i=0; i<intAry.length; i++) {
//			System.out.println(intAry[i]);
//		}

		Scanner sc = new Scanner(System.in);

//		// 배열 변수
//		int[] ary;
//		// 배열의 크기 지정 변수
//		int no;
//
//		System.out.println("배열의 크기>");
//		no = Integer.parseInt(sc.nextLine());
//
//		ary = new int[no];
//
//		System.out.println(ary.length);
//
//		// 데이터 입력
//		for (int i = 0; i < ary.length; i++) {
//			System.out.println("입력>");
//			int data = Integer.parseInt(sc.nextLine());
//			ary[i] = data;
//		}
//		// 배열의 데이터 출력
//		for (int i = 0; i < ary.length; i++) {
//			System.out.println(ary[i]);
//		}
//
//		// 국영수의 데이터를 담는 배열
//		int[] point = new int[3];
//		// [0]:국어, [1]영어, [2]:수학
//
//		System.out.println("국어점수>");
//		point[0] = Integer.parseInt(sc.nextLine());
//
//		System.out.println("영어점수>");
//		point[1] = Integer.parseInt(sc.nextLine());
//
//		System.out.println("수학점수>");
//		point[2] = Integer.parseInt(sc.nextLine());
//
//		// 1)점수의 총 합계
//		int sum = 0;
//		for (int i = 0; i < point.length; i++) {
//			sum += point[i];
//		}
//		System.out.println("총 합계 : " + sum);
//
//		// 2)점수의 평균
//		double avg = (double) sum / point.length;
//		System.out.println("평균: " + avg);
//
//		// 입력받은 데이터 갯수의 총합, 평균, 최대값, 최소값
//		// 배열
//
//		int[] intAry2;
//
//		System.out.println("데이터 갯수>");
//		// 배열의 크기
//		int num = Integer.parseInt(sc.nextLine());
//
//		intAry2 = new int[num];
//
//		for (int i = 0; i < intAry2.length; i++) {
//			// index = 0, 첫번째 칸
//			// 0번째 데이터 넣으세요-> ???
//			// 1번째 데이터 넣으세요 로 바꿔준것
//			System.out.println((i + 1) + "번째");
//
//			intAry2[i] = Integer.parseInt(sc.nextLine());
//		}
//
//		sum = 0;
//		avg = 0;
//		int max = intAry2[0];
//		int min = intAry2[0];
//		for (int i = 0; i < intAry2.length; i++) {
//			System.out.println(intAry2[i]);
//			sum += intAry2[i]; // 합계
//
//			// 최대값
//			if (max < intAry2[i]) {
//				max = intAry2[i];
//			}
//			// 최소값
//			if (min > intAry2[i]) {
//				min = intAry2[i];
//			}
//		}
//
//		System.out.println("총 합계 : " + sum);
//		System.out.println("최대값 : " + max + "\n최소값 : " + min);
//		System.out.println("평균 : " + (double) sum / intAry2.length);

		// p.201 Q.06
		boolean run = true;
		int studentNo = 0;
		int[] stuNum = null;
		int sum = 0;
		int max = 0;

		while (run) {
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수현황 | 4. 평균/최고 | 5. 종료");
			System.out.println("메뉴 선택>");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				System.out.println("학생 수>");
				studentNo = Integer.parseInt(sc.nextLine());
				stuNum = new int[studentNo];
			} else if (menu == 2) {
				for (int i = 0; i < stuNum.length; i++) {
					System.out.println("점수 입력>");
					int scores = Integer.parseInt(sc.nextLine());
					stuNum[i] = scores;
				}
			} else if (menu == 3) {
				for (int i = 0; i < stuNum.length; i++) {
					System.out.println(stuNum[i]);
				}
			} else if (menu == 4) {
				for (int i = 0; i < stuNum.length; i++) {
					sum += stuNum[i];

					if (max < stuNum[i]) {
						max = stuNum[i];
					}
				}
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수 : " + (double) sum / stuNum.length);

			} else if (menu == 5) {
				run = false;
			}
		}
		System.out.println("종료");
		
		System.out.println();

		// answer 배열에 담긴 데이터를 읽고 각 숫자마다 개수만큼'*'를 찍는다.
		// 아래 빈 영역에 코드를 입력하여 프로그램을 완성하라.

		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 }; // 1-3/2-2/3-2/4-4
		int[] counter = new int[4];
		for (int i = 0; i < answer.length; i++) {
			counter[answer[i] - 1] = counter[answer[i] - 1] + 1;
		}
		for (int i = 0; i < counter.length; i++) {
			// 이중 for문
			for (int j = 0; j < counter[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}