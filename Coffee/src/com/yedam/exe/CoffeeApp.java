package com.yedam.exe;

import java.util.Scanner;

import com.yedam.coffee.CoffeeService;

public class CoffeeApp {
	Scanner sc = new Scanner(System.in);
	CoffeeService cs = new CoffeeService();

	public CoffeeApp() {
		run();
	}

	private void run() {
		System.out.println("1. 메뉴조회 | 2. 메뉴 상세 조회 | 3. 메뉴 등록 | 4. 판매 | 5. 메뉴 삭제 | 6. 매출 | 7. 종료");
		System.out.println("메뉴 입력>");
		int menuNo = Integer.parseInt(sc.nextLine());

		while (true) {
			if (menuNo == 1) {
				cs.getCoffeeList();
				break;
			} else if (menuNo == 2) {
				cs.getDetailMenu();
	
			} else if (menuNo == 3) {
				cs.insertMenu();

			} else if (menuNo == 4) {
				cs.sellMenu();
	
			} else if (menuNo == 5) {
				cs.deleteMenu();

			} else if (menuNo == 6) {
				cs.storesales();
			} else if (menuNo == 7) {
				System.out.println("end of prog");
				break;
			}
		}
	}

}
