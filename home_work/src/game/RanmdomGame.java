package game;

import java.util.Scanner;

public class RanmdomGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = (int)(Math.random()*2)+1;
		
		while(true) {
			
			Keypad keypad = null;
			if(a == 1) {
				keypad = new RPGgame();
			}else {
				keypad = new ArcadeGame();
			}
			
			System.out.println("<<1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
			int selectNum = Integer.parseInt(sc.nextLine());
			
			if(selectNum == 1) {
				System.out.println("choice>>" + selectNum);
				keypad.leftUpButton();
			}else if(selectNum == 2) {
				System.out.println("choice>>" + selectNum);
				keypad.leftDownButton();
			}else if(selectNum ==3) {
				System.out.println("choice>>" + selectNum);
				keypad.rightUpButton(0);
			}else if(selectNum ==4) {
				System.out.println("choice>>" + selectNum);
				keypad.rightDownButton(0);
			}else if(selectNum == 5) {
				System.out.println("choice>>" + selectNum);
				keypad.changeMode();
			}else if(selectNum == 0) {
				if(a==1) {
					a = 2;
				}else {
					a = 1;
				}
			}else if(selectNum == 9) {
				System.out.println("EXIT");
				break;
			}
		}
	}
}
