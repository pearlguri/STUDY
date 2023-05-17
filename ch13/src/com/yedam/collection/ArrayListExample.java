package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		// String 문자열을 담을 수 있는 List
		List<String> list = new ArrayList<String>();

		// list 데이터 추가
		list.add("Java");
		list.add("JDBC");
		list.add("Servelt/Jstp");
		// 인덱스 2 데이터 추가
		list.add(2, "Database");
		list.add("iBatis");

		// size() -> 배열.length()
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
//		for(String data : list) {
//			System.out.println(data);
//		}

		System.out.println("========================================");

		list.remove(1); // idx 1 객체 -> JDBC 삭제
		// size() -> 배열.length()
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		
		System.out.println("========================================");
		
		//객체를 바로 삭제
		list.remove("Java");
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		
		System.out.println("=========================================");
		//전체 삭제
		list.clear();
		//확인방법 1
		list.isEmpty();
		System.out.println(list.isEmpty());
		//확인방법 2
		System.out.println(list.size());

	}
}
