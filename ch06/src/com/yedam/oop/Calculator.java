package com.yedam.oop;

public class Calculator {
	//덧셈 기능
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	//평균 기능
	double avg(int x, int y) {
		double sum = plus(x,y);
		double result = sum/2;
		return result;
	}
	
	void excute() {
		double result = avg(7,10);
		print("실행결과"+ result);
	}
	
	void print(String message) {
		System.out.println(message);
	}
	
	//정사각형(한변의 제곱)
	double areaRectangle(double width) {
		return width * width;
	}
	//직사각형(밑변 * 윗변)
	double areaRectangle(double width, double height) {
		return width * height;
	}
}
