package com.yedam.minitest;

public class CardPayment implements Payment {
	double cardRatio; //카드 할인율

	CardPayment(double cardRatio) {
		this.cardRatio = cardRatio;
	}

	@Override
	public int online(int price) {
		return price;
	}

	@Override
	public int offline(int price) {
		return price;
	}

	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인 정보");
		System.out.println("온라인 결제시 총 할인율 : " + (cardRatio + ONLINE_PAYMENT_RATIO));
		System.out.println("오프라인 결제시 총 할인율 : " + (cardRatio + OFFLINE_PAYMENT_RATIO));
		
		
	}

}
