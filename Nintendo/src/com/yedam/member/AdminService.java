package com.yedam.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.game.Game;

public class AdminService {
	Scanner sc = new Scanner(System.in);

//	1. 회원정보 조회
//	-전체 회원 조회 ( ID - PW - 이름 - 연락처 - 회원등급 - 게임팩 대여 시작일 - 게임팩 대여 종료일)
	public void getMemberInfo() {
		List<Member> list = AdminDAO.getInstance().getMemberInfo();
		System.out.println("전체 회원 조회");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("회원ID : " + list.get(i).getMemberId());
			System.out.println("회원PW : " + list.get(i).getMemberPw());
			System.out.println("회원이름 : " + list.get(i).getMemberName());
			System.out.println("회원연락처 : " + list.get(i).getMemberPhone());
			System.out.println("회원등급 : " + list.get(i).getMemberGrade());
			System.out.println("게임팩 대여 시작일 : " + list.get(i).getStart());
			System.out.println("게임팩 대여 종료일 : " + list.get(i).getEnd());
		}
	}

//	-등급별 조회(일반회원, VIP회원)
	public void getMember() {
		List<Member> list = new ArrayList<>();
		System.out.println("등급별 회원 조회");
		System.out.println("1. 일반회원 | 2. VIP회원");
		int selectNo = Integer.parseInt(sc.nextLine());

		list = AdminDAO.getInstance().getMember(selectNo);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("회원ID : " + list.get(i).getMemberId());
			System.out.println("회원PW : " + list.get(i).getMemberPw());
			System.out.println("회원이름 : " + list.get(i).getMemberName());
			System.out.println("회원연락처 : " + list.get(i).getMemberPhone());
			System.out.println("회원등급 : " + list.get(i).getMemberGrade());
			System.out.println("게임팩 대여 시작일 : " + list.get(i).getStart());
			System.out.println("게임팩 대여 종료일 : " + list.get(i).getEnd());
		}
	}

//	2. 게임팩 관리
//	-게임팩 추가
	public void insertGame() {
		Game game = new Game();
		System.out.println("게임팩 추가");

		System.out.println("게임 번호>");
		game.setGameId(sc.nextLine());

		System.out.println("게임 이름>");
		game.setGameName(sc.nextLine());

		int result = AdminDAO.getInstance().insertGame(game);

		if (result > 0) {
			System.out.println("게임팩 등록 성공");
		} else {
			System.out.println("게임팩 등록 실패");
		}
	}

//	-게임팩 삭제
	public void deleteGame() {
		System.out.println("게임팩 삭제");
		System.out.println("삭제할 게임팩 ID>");
		String dGame = sc.nextLine();

		int result = AdminDAO.getInstance().deleteGame(dGame);

		if (result == 1) {
			System.out.println("게임 삭제 완료!!");
		} else {
			System.out.println("게임 삭제 실패ㅠㅠ");
		}

	}

//	3. 회원 삭제(회원 아이디 입력시)
	public void deleteMember() {
		System.out.println("회원 삭제");
		System.out.println("삭제할 회원 ID>");
		String mGame = sc.nextLine();

		int result = AdminDAO.getInstance().deleteMember(mGame);

		if (result == 1) {
			System.out.println("회원 삭제 완료!!");
		} else {
			System.out.println("회원 삭제 실패ㅠㅠ");
		}
	}
}
