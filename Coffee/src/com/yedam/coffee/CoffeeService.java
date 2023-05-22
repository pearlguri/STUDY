package com.yedam.coffee;

import java.util.List;
import java.util.Scanner;

public class CoffeeService {
	Scanner sc = new Scanner(System.in);

	// 1. 메뉴 조회
	public void getCoffeeList() {
		List<Coffee> list = CoffeeDAO.getInstance().getCoffeeList();
		if (list.size() == 0) {
			System.out.println("메뉴 정보가 없습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("메뉴 : " + list.get(i).getCoffeeMenu() + " 가격 : " + list.get(i).getCoffeePrice());
			}
		}
	}

	// 2. 메뉴 상세 조회
	public void getDetailMenu() {
		System.out.println("메뉴 입력>");
		String menu = sc.nextLine();
		Coffee coffee = CoffeeDAO.getInstance().getDetailMenu(menu);

		if (coffee != null) {
			System.out.println("메뉴 : " + coffee.getCoffeeMenu() + " 가격 : " + coffee.getCoffeePrice() + " 설명 : "
					+ coffee.getCoffeeExplain());
		}
	}

	// 3. 메뉴 등록
	public void insertMenu() {
		Coffee coffee = new Coffee();

		System.out.println("메뉴 입력>");
		coffee.setCoffeeMenu(sc.nextLine());

		System.out.println("가격 입력>");
		coffee.setCoffeePrice(Integer.parseInt(sc.nextLine()));

		System.out.println("설명 입력>");
		coffee.setCoffeeExplain(sc.nextLine());

		int result = CoffeeDAO.getInstance().insertMenu(coffee);

		if (result > 0) {
			System.out.println("메뉴 등록 완료");
		} else {
			System.out.println("메뉴 등록 실패");
		}
	}

	// 4. 판매
	public void sellMenu() {
		System.out.println("메뉴 입력>");
		String menu = sc.nextLine();
		

		int result = CoffeeDAO.getInstance().sellMenu(null);
		if (result > 0) {
			System.out.println("판매량 완료");
		} else {
			System.out.println("판매 실패");
		}
	}

	// 5. 메뉴 삭제
	public void deleteMenu() {
		System.out.println("메뉴 입력>");
		String menu = sc.nextLine();
		int result = CoffeeDAO.getInstance().deleteMenu(menu);
		if (result > 0) {
			System.out.println("메뉴 삭제 완료");
		} else {
			System.out.println("메뉴 삭제 실패");
		}
	}
	
	//6. 매출
	public void sell() {
		List<Coffee> money = CoffeeDAO.getInstance().sales();
		for(int i=0; i<money.size(); i++) {
			System.out.println("메뉴 : " + money.get(i).getCoffeeMenu());
			System.out.println("판매갯수 : " + money.get(i).getCoffeeSales());
			System.out.println("판매 금액 : " + money.get(i).getCoffeeSales());
		}
	}
}
