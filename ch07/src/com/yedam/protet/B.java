package com.yedam.protet;

public class B extends A{
	@Override
	public void method() {
		A a = new A();
		a.field = "value";
		a.method();
	}
}
