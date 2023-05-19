package com.yedam.store;

import java.util.List;
import java.util.Scanner;

public class StoreService {
	Scanner sc = new Scanner(System.in);

	// 모든가게 정보 조회
	public void getStoreList() {
		List<Store> list = StoreDAO.getInstance().getStoreList();
		if (list.size() == 0) {
			System.out.println("가게 정보가 없습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("✔가게번호 : " + list.get(i).getStore_id());
				System.out.println("✔가게명 : " + list.get(i).getStore_name());
				System.out.println("✔가게연락처 : " + list.get(i).getStore_tel());
				System.out.println("✔주소 : " + list.get(i).getStore_addr());
				System.out.println("✔매출 : " + list.get(i).getSales());
			}
		}
	}

	// 지역구별 매출 합계
	public void getStoreSales() {
		List<Store> list = StoreDAO.getInstance().getStoreSales();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("지역구 : " + list.get(i).getStore_addr());
			System.out.println("매출 합계 : " + list.get(i).getSales());
		}
	}

	// 가게 정보 입력
	public void insertStore() {
		Store store = new Store();

		System.out.println("(☞ﾟヮﾟ)☞가게번호>");
		store.setStore_id(Integer.parseInt(sc.nextLine()));

		System.out.println("(☞ﾟヮﾟ)☞가게명>");
		store.setStore_name(sc.nextLine());

		System.out.println("(☞ﾟヮﾟ)☞가게연락처>");
		store.setStore_tel(sc.nextLine());

		System.out.println("(☞ﾟヮﾟ)☞주소>");
		store.setStore_addr(sc.nextLine());

		System.out.println("(☞ﾟヮﾟ)☞매출>");
		store.setSales(Integer.parseInt(sc.nextLine()));

		int result = StoreDAO.getInstance().insertStore(store);

		if (result > 0) {
			System.out.println("가게 정보가 정상적으로 등록 되었습니다.");
		} else {
			System.out.println("가게 정보가 등록되지 않았습니다.");
		}
	}

	// 매출 수정
	public void updateSales() {
		Store store = new Store();
		System.out.println("매 출 수 정");

		System.out.println("가게 번호>");
		store.setStore_id(Integer.parseInt(sc.nextLine()));

		System.out.println("매출>");
		store.setSales(Integer.parseInt(sc.nextLine()));
		int result = StoreDAO.getInstance().updateSales(store);

		if (result > 0) {
			System.out.println("매출이 정상적으로 수정 되었습니다");
		} else {
			System.out.println("매출이 수정되지 않았습니다.");
		}
	}
}
