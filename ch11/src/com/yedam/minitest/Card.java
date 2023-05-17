package com.yedam.minitest;

public class Card {
	int cardNo;
	int validDate;
	int CVC;

	Card(int cardNo, int validDate, int CVC) {
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.CVC = CVC;
	}

	public int getCardNo() {
		return cardNo;
	}

	public int getValidDate() {
		return validDate;
	}

	public int getCVC() {
		return CVC;
	}

	public void showCardInfo() {
		System.out.println("Card NO : " + cardNo);
		System.out.println("유효기간 : " + validDate);
		System.out.println("CVC : " + CVC);
	}
}
