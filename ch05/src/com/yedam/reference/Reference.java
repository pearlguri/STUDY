package com.yedam.reference;

public class Reference {

	public static void main(String[] args) {
		//참조 : 배열 array
		int[] array = {1,2,3,4,5,6};
		int[] array2 = {1,2,3,4,5,6};
		int[] array3 = null; //변수 껍데기만 존재. heap과 연결되어 있지 않음. 참조할 객체가 없음.
		
		System.out.println(array); //array 변수 주소 => heap 영역
		System.out.println(array2); //array2 변수 주소		
		System.out.println(array == array2); //array와 array2 주소 비교
		System.out.println(array[0]); //array배열의 1
		//System.out.println(array3[0]); //nullpointexception 뜸. 참조할수있는 객체가 없다. 변수에 객체가 없다.
		
		System.out.println(array3 == null);
		
		if(array3 ==null) {
			//array3이 null 경우
		}else {
			//array3에 객체 있는 경우
		}

	}

}
