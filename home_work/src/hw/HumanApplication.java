package hw;

public class HumanApplication {
	public static void main(String[] args) {
		//- 출력결과
		//홍길동님의 신장 168, 몸무게 45, 표준체중 61.2 입니다.
		//박둘이님의 신장 168, 몸무게 90, 비만입니다.
	//- 조건
		//변수는 Human 클래스 타입으로 선언하여 하나만 사용한다.
		
		Human human = new ObesityInfo("홍길동", 168, 45);
		
		human.getInformation();
	}
}

