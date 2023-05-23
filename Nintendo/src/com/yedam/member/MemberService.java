package com.yedam.member;

import java.util.Scanner;

public class MemberService {
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);

	// 1. 로그인
	public void login() {
		Member member = null;
		System.out.println("ID>");
		String id = sc.nextLine();

		System.out.println("PW>");
		String pw = sc.nextLine();

		member = MemberDAO.getInstance().login(id);

		if (member != null) {
			if (member.getMemberPw().equals(pw)) {
				System.out.println("로그인 되었습니다.");
				System.out.println(member.getMemberId() + " 님 환영합니다.");
				memberInfo = member;
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}

	// 2. 회원가입
	public void insertMember() {
		System.out.println("회원가입");
		String id = "";
		while(true) {
			System.out.println("ID>");
			id = sc.nextLine();
			Member member = MemberDAO.getInstance().login(id);
			if(member != null) {
				System.out.println("존재하는 ID 입니다.");
			}
		}
	}
}
