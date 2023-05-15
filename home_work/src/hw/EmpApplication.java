package hw;

public class EmpApplication {
	public static void main(String[] args) {
//		- 출력결과
//		이름:이지나  연봉:3000  부서:교육부
//		수퍼클래스
//		서브클래스
		
		EmpDept emp = new EmpDept("이지나", 3000, "교육부");
		
		emp.getInformation();
		emp.print();
	}
}
