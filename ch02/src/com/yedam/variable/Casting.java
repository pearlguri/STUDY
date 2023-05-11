package com.yedam.variable;

public class Casting {
	public static void main(String[] args) {
		//자동 타입 변환
		byte bValue = 10;
		int iValue = bValue;		
		System.out.println("iValue : " + iValue);
		
		char cValue = '가';
		iValue = cValue;		
		System.out.println("가의 유니코드 : " + iValue);
		
		iValue = 50;
		long lValue = iValue;		 
		System.out.println("lValue : " + lValue);
		
		double dValue = lValue;		
		System.out.println("dValue : " + dValue);
		
		//강제 타입 변환
		int iVar = 127;
		byte bVar = (byte)iVar;
		System.out.println("bVar : " + bVar);
		
		int iVar2 = 44032;
		char cVar = (char)iVar2;
		System.out.println("cVar : " + cVar);
		
		//실수 <-> 정수 강제 타입 변환
		//자동 타입 변환 : int(3) -> double = 3.0
		//강제 타입 변환 : double(3.5) -> int = 소수점 아래 내용을 제외후 정수 변환
		double dVar = 3.14;
		iVar2 = (int)dVar;
		System.out.println("iVar2 : " + iVar2);
		
		
		
		
	}

}
