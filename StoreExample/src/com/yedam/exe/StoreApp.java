package com.yedam.exe;

import java.util.Scanner;

import com.yedam.store.StoreService;

public class StoreApp {
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	StoreService ss = new StoreService();

	public StoreApp() {
		start();
	}

	private void start() {
		System.out.println("1. 모든 가게 정보 조회 | 2. 지역구별 매출 합계 조회 | 3. 가게 정보 입력 | 4. 매출수정 | 5. 종료");
		System.out.println("입력>");
		int menu = Integer.parseInt(sc.nextLine());

		switch (menu) {
		case 1:
			// 모든 가게 정보 조회
			ss.getStoreList();
			break;
		case 2:
			// 지역구별 매출 합계 조회
			ss.getStoreSales();
			break;
		case 3:
			// 가게 정보 입력
			ss.insertStore();
			break;
		case 4:
			// 매출 수정
			ss.updateSales();
		case 5:
			run = false;
			System.out.println("프로그램 종료");
			break;
		}

	}
}
