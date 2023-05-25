package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class MemberApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();

	public MemberApp() {
		memberRun();
	}

	private void memberRun() {
		boolean flag = true;
		while (flag) {
			System.out.println("1. 내 정보 조회 | 2. 게임팩 대여 및 반납 | 3. 게임팩 현황 조회 | 4. 내 정보 수정 | 5. 뒤로가기");
			int selectNo = Integer.parseInt(sc.nextLine());

			switch (selectNo) {
			case 1:
				ms.getMemberInfo();
				break;
			case 2:
				ms.rentalGame();
				break;
			case 3:
				System.out.println("1. 내가 대여 중인 게임팩 | 2. 게임팩 전체 조회 | 3. 게임팩 단건 조회");
				int gameNo = Integer.parseInt(sc.nextLine());
				if (gameNo == 1) {
					ms.getMyGame();
					break;
				}else if(gameNo == 2) {
					ms.getGameInfo();
					break;
				}else if (gameNo == 3) {
					ms.getGame();
					break;
				}
			case 4:
				System.out.println("1. 비밀번호 수정 | 2. 연락처 수정");
				int changeNo = Integer.parseInt(sc.nextLine());
				if (changeNo == 1) {
					ms.changePw();
					break;
				} else if (changeNo == 2) {
					ms.changePhone();
					break;
				}
				break;
			case 5:
				flag = false;
				MemberService.memberInfo = null;
				System.out.println("회원 권한 종료");
				break;
			}
		}
	}
}
