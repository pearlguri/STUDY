package com.yedam.minitest;

public class PaymentApplication {
	public static void main(String[] args) {
		int price = 10000;

		Payment card = new CardPayment(0.08);
		card.showInfo();
		System.out.println("온라인 결제 금액: " + card.online(8700));
		System.out.println("오프라인 결제 금액: " + card.offline(8900));

		Payment simple = new SimplePayment(0.05);
		simple.showInfo();
		System.out.println("온라인 결제 금액 : " + simple.online(9000));
		System.out.println("오프라인 결제 금액 : " + simple.offline(9200));
	}
}
