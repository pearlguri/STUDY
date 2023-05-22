package com.yedam.exe;

import java.util.Scanner;

import com.yedam.account.AccountService;
import com.yedam.member.MemberService;

public class AccountApp {
	AccountService as = new AccountService();
	Scanner sc = new Scanner(System.in);

	public AccountApp() {
		run();
	}

	private void run() {
		while (true) {
			menu();
			String menuNo = sc.nextLine();
			if (menuNo.equals("1")) {
				// 고객등록
				as.insertMember();
			} else if (menuNo.equals("2")) {
				// 계좌개설
				as.insertAccount();
			} else if (menuNo.equals("3")) {
				// 입출금 -> 2가지 (입금, 출금)
				as.inoutMoney();
			} else if (menuNo.equals("4")) {
				// 계좌이체
				as.transferMoney();
			} else if (menuNo.equals("5")) {
				// 계좌해지
				as.deleteAccount();
			} else if (menuNo.equals("6")) {
				// 뒤로가기
				System.out.println("은행원 업무 종료");
				MemberService.memberInfo = null;
				break;
			}
		}
	}

	private void menu() {
		System.out.println("1. 고객등록 | 2. 계좌계설 | 3. 입출금 | 4. 계좌이체 | 5. 계좌해지 | 6. 뒤로가기");
	}

}
