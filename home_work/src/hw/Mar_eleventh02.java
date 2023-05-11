package hw;

public class Mar_eleventh02 {
	String name;
	int price;
	
	Mar_eleventh02(){
		
	}
	
	Mar_eleventh02(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	void getInfo() {
		System.out.println(name + " : " + price);
	}
}
