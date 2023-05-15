package com.yedam.inheri;

public class Application01 {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("아이폰", "스그", "SK");
		
		//CellPhone(부모) Class
		System.out.println("모델 : " + sp.model);
		System.out.println("모델 : " + sp.color);
		
		//SmartPhone(자식) Class
		System.out.println("모델 : " + sp.agency);
		
		//CellPhone(부모) Class
		sp.powerOn();
		sp.bell();
		sp.hangUp();
		sp.powerOff();
		
		//SmartPhone(자식) Class
		sp.kakaoExe();
		sp.kakaoExit();
		sp.Info();
		
	}

}
