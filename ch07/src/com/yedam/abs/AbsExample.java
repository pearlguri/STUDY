package com.yedam.abs;

public class AbsExample {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("길등");
		sp.internetSarch();
		sp.turnOn();
		sp.turnOff();

		Phone p = sp;
		p.turnOn();
		p.turnOff();

		SmartPhone sp2 = (SmartPhone) p;
		sp2.internetSarch();
		sp2.turnOn();
		sp2.turnOff();

	}
}
