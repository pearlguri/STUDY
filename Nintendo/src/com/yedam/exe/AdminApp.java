package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.AdminService;
import com.yedam.member.MemberService;

public class AdminApp {
	Scanner sc = new Scanner(System.in);
	AdminService as = new AdminService();

	public AdminApp() {
		adminRun();
	}

	private void adminRun() {
		boolean flag = true;
		while (flag) {
			System.out.println("1. 회원정보 조회 | 2. 게임팩 조회 | 3. 게임팩 관리 | 4. 회원 삭제 | 5. 뒤로가기");
			int selectNo = Integer.parseInt(sc.nextLine());

			switch (selectNo) {
			case 1:
				System.out.println("1. 전체 회원 조회 | 2. 등급별 회원 조회 | 3. 회원 등급 수정");
				int mNo = Integer.parseInt(sc.nextLine());
				if (mNo == 1) {
					as.getMemberInfo();
					break;
				} else if (mNo == 2) {
					as.getMember();
					break;
				}else if(mNo ==3) {
					as.modifyGrade();
					break;
				}
			case 2:
				System.out.println("1. 전체 조회 | 2. 단건 조회");
				int sNo = Integer.parseInt(sc.nextLine());
				if(sNo == 1) {
					as.getGameInfo();
					break;
				}else if(sNo == 2) {
					as.getGame();
					break;
				}
			case 3:
				System.out.println("1. 게임팩 추가 | 2. 게임팩 삭제");
				int gNo = Integer.parseInt(sc.nextLine());
				if (gNo == 1) {
					as.insertGame();
					break;
				} else if (gNo == 2) {
					as.deleteGame();
					break;
				}
				break;
			case 4:
				as.deleteMember();
				break;
			case 5:
				flag = false;
				MemberService.memberInfo = null;
				System.out.println("관리자 권한 종료");
				break;
			}
		}
	}
}
