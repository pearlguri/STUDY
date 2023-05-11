package hw;

import java.util.Scanner;

public class MarEleventh02 {
	public static void main(String[] args) {

		// 문제2) 다음은 키보드로부터 상품명과 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품명 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		// 출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.

		Scanner sc = new Scanner(System.in);

		int goodsNum = 0;

		MarEleventh01[] gAry = null;

		while (true) {
			System.out.println("==========================================");
			System.out.println("1.상품수|2.상품명 및 가격|3.제품별 가격|4.분석|5.종료");
			System.out.println("==========================================");

			int selectNum = Integer.parseInt(sc.nextLine());

			if (selectNum == 1) {
				System.out.println("상품 수 입력>");
				goodsNum = Integer.parseInt(sc.nextLine());
				
			} else if (selectNum == 2) {
				
				//왜 바로 입력은 안되지??????
				//gAry[i].name = sc.nextLine();이 안됨ㅠㅠㅠ
				//계속 gary[i]가 null이라서 안된다고 NullPointerException뜬다ㅠㅠ
				gAry = new MarEleventh01[goodsNum];

				for (int i = 0; i < gAry.length; i++) {
					MarEleventh01 goods = new MarEleventh01();
					
					System.out.println("상품명>");
					goods.name = sc.nextLine();
					

					System.out.println("가격>");
					goods.price = Integer.parseInt(sc.nextLine());
				}
			} else if (selectNum == 3) {
				for(int i=0; i<gAry.length; i++) {
					gAry[i].getInfo();
				}
			} else if (selectNum == 4) {
				
			} else if (selectNum == 5) {
				System.out.println("종료");
				break;
			}

		}
	}
}