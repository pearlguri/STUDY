package com.yedam.access;

public class Application01 {
	public static void main(String[] args) {
		Access ac = new Access();
		ac.free = "public";
		ac.parent = "protected";
		ac.basic = "default";
//		ac.privacy = "private"; //Access class안에서만 사용 가능
		
		ac.instead();
		
		
		
		
		
	}
}
