package com.yedam.minitest;

public class Toss extends Card {
	String company = "Toss";
	String cardStaff;

	Toss(int cardNo, int validDate, int CVC, String cardStaff) {
		super(cardNo, validDate, CVC);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card NO," + cardNo);
		System.out.println("담당직원 - " + cardStaff + ", " + company);

	}

}
