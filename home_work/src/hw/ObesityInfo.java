package hw;

public class ObesityInfo extends Human {
//	- 메소드는 다음과 같이 정의한다.
//	(1) public void getInformation() : 이름, 키, 몸무게와 비만도를 출력하는 기능
//	(2) public double getObesity() : 비만도를 구하는 기능
//	( * 비만도 : (Weight - 표준 체중)/표준체중 * 100 )
//	(BMI가 18.5 이하면 저체중 ／ 18.5 ~ 22.9 사이면 정상 ／ 23.0 ~ 24.9 사이면 과체중 ／ 25.0 이상부터는 비만으로 판정.)

	double avg = (double)(height - 100) * 0.9;
	double obesity = (weight - avg) / avg * 100;

	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
	}

	public void getObesity() { // 자식개체만의 것

		if (obesity >= 18.5 && obesity <= 22.9) {
			System.out.println("정상");
		} else if (obesity >= 23.0 && obesity <= 24.9) {
			System.out.println("과체중");
		} else if (obesity >= 25.0) {
			System.out.println("비만");
		}
	}

	public void getInformation() {
		// 홍길동님의 신장 168, 몸무게 45, 표준체중 61.2 입니다.
		// 박둘이님의 신장 168, 몸무게 90, 비만입니다.
		System.out.println(name + "님의 신장 " + height + ", 몸무게 " + weight + ", " + obesity + " " + avg + "입니다.");
	}

}
