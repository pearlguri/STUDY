package hw;

public interface Keypad {
//	1) Keypad 인터페이스를 정의한다.
//- 다음과 같이 상수 필드를 정의한다.
//(1) public static final int NORMAL_MODE = 0;
//(2) public static final int HARD_MODE = 1;
//- 다음과 같이 추상 메서드를 정의한다.
//(1) public abstract void leftUpButton() : 왼쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
//(2) public abstract void leftDownButton() : 왼쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
//(3) public abstract void rightUpButton() : 오른쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
//(4) public abstract void rightDownButton() : 오른쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
//(5) public abstract void changeMode() : 모드를 바꾸고 현재 모드를 출력하는 기능 ( NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	//상수
	public static final int NORMAL_MODE = 0;
	public static final int HARD_MODE = 1;
	
	//추상 메소드
	public void leftUpButton();
	public void leftDownButton();
	public void rightUpButton(int mode);
	public void rightDownButton(int mode);
	public void changeMode(int mode);
	
}
