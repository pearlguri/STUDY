package hw;

public class StandardWeightInfo extends Human {

//	 메소드는 다음과 같이 정의한다.
//		(1) public void getInformation() : 이름, 키, 몸무게와 표준체중을 출력하는 기능
//		(2) public double getStandardWeight() : 표준체중을 구하는 기능
//		( * 표준 체중 : (Height - 100) * 0.9 )
	
	double avg = (double)(height - 100) * 0.9;
	
	
	StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
	}

	public double getStandarWeight() {
		return avg;
	}
	
	public void getInformation() {
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("표준체중 :  " + avg);
	}
	
}
