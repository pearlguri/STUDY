package hw;

public class EmpDept extends Employee {

	String deptName;

	EmpDept(String name, int salary, String deptName) {
		super(name, salary);
		this.deptName = deptName;
	}

	public String getDeptName() {
		return deptName;
	}

	@Override
//	(1) public void getInformation() : 이름과 연봉, 부서를 출력하는 기능
//	(2) public void print() : "수퍼클래스\n서브클래스"란 문구를 출력하는 기능
	public void getInformation() {
		System.out.println("이름 : " + name);
		System.out.println("연봉 : " + salary);
		System.out.println("부서 : " + deptName);
	}
	public void print() {
		System.out.println("수퍼클래스\n서브클래스");
	}
}
