package com.yedam.account;

import java.util.Scanner;

import com.yedam.member.Member;

public class AccountService {
	Scanner sc = new Scanner(System.in);

	// 1.고객등록
	public void insertMember() {
		Member member = new Member();
		System.out.println("👶고 객 등 록👶");

		System.out.println("ID>");
		member.setMemberId(sc.nextLine());

		System.out.println("PW>");
		member.setMemberPw(sc.nextLine());

		System.out.println("NAME>");
		member.setMemberName(sc.nextLine());

		int result = AccountDAO.getInstance().insertMember(member);

		if (result > 0) {
			System.out.println("고객 등록이 정상적으로 등록 되었습니다.");
		} else {
			System.out.println("고객 등록이 정상적으로 등록되지 않았습니다.");
		}

	}

	// 2.계좌개설
	public void insertAccount() {
		Account account = new Account();
		System.out.println("*** 계좌 개설 ***");

		System.out.println("계좌번호>");
		account.setAccountId(sc.nextLine());

		System.out.println("예금액>");
		account.setAccountBalance(Integer.parseInt(sc.nextLine()));

		System.out.println("고객ID>");
		account.setMemberId(sc.nextLine());

		int result = AccountDAO.getInstance().insertAccount(account);

		if (result > 0) {
			System.out.println("계좌 개설 성공");
		} else {
			System.out.println("계좌 개설 실패");
		}
	}

	// 3.입출금
	public void inoutMoney() {
		System.out.println("*** 입출금 ***");

		System.out.println("1) 입금 | 2) 출금");
		int selectNo = Integer.parseInt(sc.nextLine());

		System.out.println("계좌번호>");
		Account account = new Account();
		account.setAccountId(sc.nextLine());

		if (selectNo == 1) {
			System.out.println("입금 금액>");
		} else if (selectNo == 2) {
			System.out.println("출금 금액>");
		}

		account.setAccountBalance(Integer.parseInt(sc.nextLine()));

		int result = AccountDAO.getInstance().inoutMoney(account, selectNo);

		if (result > 0) {
			if (selectNo == 1) {
				System.out.println("입금 성공");
			} else {
				System.out.println("출금 성공");
			}
		} else {
			if (selectNo == 1) {
				System.out.println("입금 실패");
			} else {
				System.out.println("출금 실패");
			}
		}
	}

	// 4.계좌이체
	public void transferMoney() {
		System.out.println("*** 계좌 이체 ***");
		System.out.println("받는 계좌>");
		String toAccount = sc.nextLine();

		System.out.println("보내는 계좌>");
		String fromAccount = sc.nextLine();

		System.out.println("이체 금액");
		int balnace = Integer.parseInt(sc.nextLine());

		int result = AccountDAO.getInstance().transferMoney(toAccount, fromAccount, balnace);

		if (result == 1) {
			System.out.println("이체 성공!!");
		} else {
			System.out.println("이제 실패 ㅠㅠ");
		}
	}

	// 5.계좌해지
	public void deleteAccount() {
		System.out.println("*** 계좌 해지 ***");
		System.out.println("계좌>");
		String accountId = sc.nextLine();

		int result = AccountDAO.getInstance().deleteAccount(accountId);

		if (result == 1) {
			System.out.println("계좌 해지 완료!!");
		} else {
			System.out.println("계좌 해지 실패 ㅠㅠ");
		}
	}
}
