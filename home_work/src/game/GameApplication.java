package game;

public class GameApplication {
	public static void main(String[] args) {
//		4)  아래와 같은 출력결과가 나오도록 실행코드를 구현한다.
//	- 출력결과
//		RPGgame 실행
//		캐릭터가 위쪽으로 이동한다.
//		캐릭터가 한칸단위로 점프한다.
//		현재 모드 : HARD_MODE
//		캐릭터가 두칸단위로 점프한다.
//		캐릭터가 HIT 공격.
//		캐릭터가 아래쪽으로 이동한다.
//		현재 모드 : NORMAL_MODE
//		캐릭터가 일반 공격.
//		======================
//		ArcadeGame 실행
//		캐릭터가 앞쪽으로 이동한다.
//		캐릭터가 일반 공격
//		캐릭터가 뒤쪽으로 이동한다.
//		현재 모드 : HARD_MODE
//		캐릭터가 연속 공격.
//		캐릭터가 앞쪽으로 이동한다.
//		캐릭터가 Double HIT 공격.
		
		RPGgame rpg = new RPGgame();
		rpg.leftUpButton();
		rpg.rightUpButton(0);
		rpg.changeMode(0);
		rpg.rightUpButton(1);
		rpg.rightDownButton(1);
		rpg.leftDownButton();
		rpg.changeMode(1);
		rpg.rightDownButton(0);
		
		System.out.println("===========================");
		
		ArcadeGame arcade = new ArcadeGame();
		arcade.leftUpButton();
		arcade.rightUpButton(0);
		arcade.leftDownButton();
		arcade.changeMode(0);
		arcade.rightUpButton(1);
		arcade.leftUpButton();
		arcade.rightDownButton(1);
	}
}
