package com.yedam.oop;

import java.util.Scanner;

public class Application06 {

	public static void main(String[] args) {

		// 1.학생수
		// 2.정보입력
		// 3.정보확인
		// 4.분석 - 전체 학생의 점수 총합(국+영+수)
		// - 총합이 평균
		// - 개인별 가장 점수가 높은 과목 / 낮은 과목
		// 5.종료

		Student[] stuAry = null;

		int studentNum = 0;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=====================================");
			System.out.println("1.학생수|2.정보입력|3.정보확인|4.분석|5.종료");
			System.out.println("=====================================");

			String selectNo = sc.nextLine();

			if (selectNo.equals("1")) {
				System.out.println("학생 수 입력>");
				studentNum = Integer.parseInt(sc.nextLine());
			} else if (selectNo.equals("2")) {
				System.out.println("정보입력>");
				stuAry = new Student[studentNum];

				for (int i = 0; i < stuAry.length; i++) {

					stuAry[i] = new Student();

					System.out.println("이름>");
					stuAry[i].name = sc.nextLine();

					System.out.println("학년>");
					stuAry[i].grade = sc.nextLine();

					System.out.println("국어점수>");
					stuAry[i].lang = Integer.parseInt(sc.nextLine());

					System.out.println("영어점수>");
					stuAry[i].eng = Integer.parseInt(sc.nextLine());

					System.out.println("수학점수>");
					stuAry[i].math = Integer.parseInt(sc.nextLine());

				}
			} else if (selectNo.equals("3")) {
				for (int i = 0; i < stuAry.length; i++) {
					System.out.println((i + 1) + "번째 학생 정보***");
					stuAry[i].getInfo();
				}
			} else if (selectNo.equals("4")) {
				int sum = 0;
				double avg = 0;
				int max = 0;
				int min = 0;

				for (int i = 0; i < stuAry.length; i++) {
					sum += stuAry[i].lang + stuAry[i].eng + stuAry[i].math;

					max = stuAry[i].lang;
					min = stuAry[i].lang;

					if (stuAry[i].eng < stuAry[i].math) {
						if (max < stuAry[i].math) {
							max = stuAry[i].math;
						}
					} else {
						if (max < stuAry[i].eng) {
							max = stuAry[i].eng;
						}
					}

					if (stuAry[i].eng < stuAry[i].math) {
						if (min > stuAry[i].math) {
							min = stuAry[i].math;
						}
					} else {
						if (min > stuAry[i].eng) {
							min = stuAry[i].eng;
						}
					}
				}
				
				avg = (double) sum / studentNum;

				System.out.println("전체 학생 점수 총합 : " + sum);
				System.out.println("총합의 평균 : " + avg);
				System.out.println("개인별 가장 점수가 높은 과목 : " + max);
				System.out.println("개인별 가장 점수가 낮은 과목 : " + min);

			} else if (selectNo.equals("5")) {
				System.out.println("종료");
				break;
			}
		}

	}

}
