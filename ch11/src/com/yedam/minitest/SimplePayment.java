package com.yedam.minitest;

public class SimplePayment implements Payment{
	
	double simplePaymentRatio;
	
	SimplePayment(double simplePaymentRatio){
		this.simplePaymentRatio = simplePaymentRatio;
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
		System.out.println("*** 간편결제 시 할인정보");
		System.out.println("온라인 결제시 총 할인율 : " + (simplePaymentRatio + ONLINE_PAYMENT_RATIO));
		System.out.println("오프인 결제시 총 할인율 : " + (simplePaymentRatio + OFFLINE_PAYMENT_RATIO));
	}

}
