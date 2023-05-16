package employee;

public class Employee {
	String name;
	int salary;
	
	Employee(String name, int salary){
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
	
	public void getInformation() {
		//이름과 연봉을 출력하는 기능
		System.out.println("이름 : " + name);
		System.out.println("연봉 : " + salary);
	}
	
	public void print() {
		//"수퍼클래스"란 문구를 출력하는 기능
		System.out.println("수퍼클래스");
	}
}
