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

//	-회원 등급 수정
	public void modifyGrade() {
		System.out.println("회원 등급 수정");
		System.out.println("1. 일반 -> VIP | 2. VIP -> 일반");
		int mMenu = Integer.parseInt(sc.nextLine());

		Member member = new Member();

		System.out.println("회원ID>");
		String mID = sc.nextLine();

		member.setMemberId(mID);

		int result = AdminDAO.getInstance().modifyGrade(member, mMenu);

		if (result > 0) {
			System.out.println("회원등급 수정이 정상적으로 처리되었습니다.");
		} else {
			System.out.println("회원등급 수정이 처리되지 않았습니다.");
		}
	}

//	2. 게임팩 조회
// - 전체조회
	public void getGameInfo() {
		List<Game> list = AdminDAO.getInstance().getGameInfo();
		System.out.println("전체 게임팩 조회");
		if (list.size() == 0) {
			System.out.println("등록된 게임팩이 없습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("게임번호 : " + list.get(i).getGameId());
				System.out.println("게임명: " + list.get(i).getGameName());
				System.out.println("남은 수량: " + list.get(i).getGNum());
				System.out.println("대여시작 : " + list.get(i).getStart());
				System.out.println("대여종료 : " + list.get(i).getEnd());
				System.out.println("대여여부: " + list.get(i).getGameStatus());
				System.out.println("빌린회원 : " + list.get(i).getMemberId());
				System.out.println("남은 대여 일수 : " + list.get(i).getLeft());
			}
		}
	}

// - 단건조회
	public void getGame() {
		System.out.println("게임번호>");
		String gameId = sc.nextLine();
		Game game = AdminDAO.getInstance().getGame(gameId);

		if (game != null) {
			System.out.println("게임번호 : " + game.getGameId());
			System.out.println("게임명: " + game.getGameName());
			System.out.println("남은 수량: " + game.getGNum());
			System.out.println("대여시작 : " + game.getStart());
			System.out.println("대여종료 : " + game.getEnd());
			System.out.println("대여여부: " + game.getGameStatus());
			System.out.println("빌린회원 : " + game.getMemberId());
			System.out.println("남은 대여 일수 : " + game.getLeft());
		} else {
			System.out.println("조회된 게임 정보가 없습니다.");
		}
	}

//	3. 게임팩 관리
//	-게임팩 추가
	public void insertGame() {
		Game game = new Game();
		System.out.println("게임팩 추가");

		System.out.println("게임 번호는 등록 순서에 따라 자동 적용됩니다.");

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

//	4. 회원 삭제(회원 아이디 입력시)
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
