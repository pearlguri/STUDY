package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class NintendoApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();

	public NintendoApp() {
		run();
	}

	public void run() {
		while (true) {
			if (MemberService.memberInfo == null) {
				System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
				int menu = Integer.parseInt(sc.nextLine());
				if (menu == 1) {
					ms.login();
				} else if (menu == 2) {
					ms.insertMember();
				} else if (menu == 3) {
					System.out.println("프로그램 종료");
					break;
				}
			} else if (MemberService.memberInfo != null) {
				if (MemberService.memberInfo.getMemberGrade().equals("N")
						|| MemberService.memberInfo.getMemberGrade().equals("V")) {
					new MemberApp();
				} else if (MemberService.memberInfo.getMemberGrade().equals("A")) {
					new AdminApp();
				}
			}
		}
	}
}
