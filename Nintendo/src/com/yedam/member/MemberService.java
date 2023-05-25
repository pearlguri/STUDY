package com.yedam.member;

import java.util.List;
import java.util.Scanner;

import com.yedam.game.Game;
import com.yedam.review.Review;

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

	// 2. 로그아웃
	public void logout() {
		memberInfo = null;
		System.out.println("로그아웃 완료");
	}

	// 3. 회원가입
	public void insertMember() {
		System.out.println("회원가입");
//		String id = "";
//		while (true) {
//			System.out.println("ID>");
//			id = sc.nextLine();
//			Member member = MemberDAO.getInstance().login(id);
//			if (member != null) {
//				System.out.println("존재하는 ID 입니다.");
//			} else if (member == null) {
//				System.out.println("사용가능한 ID입니다.");
//				break;
//			}
//		}

		System.out.println("회원 ID는 가입순서에 따라 자동 적용됩니다.");
		System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");

		System.out.println("PW>");
		String pw = sc.nextLine();

		System.out.println("Name>");
		String name = sc.nextLine();

		System.out.println("Phone>");
		String phone = sc.nextLine();

		Member mem = new Member();
		mem.setMemberPw(pw);
		mem.setMemberName(name);
		mem.setMemberPhone(phone);

		int result = MemberDAO.getInstance().insertMember(mem);

		if (result > 0) {
			System.out.println("회원가입을 축하합니다.");
		} else {
			System.out.println("회원가입 실패!!");
		}
	}

	// 4. 정보조회 - ID - PW - 이름 - 연락처 - 회원등급
	public void getMemberInfo() {
		System.out.println("내 정보 조회");
		Member member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		System.out.println("ID : " + member.getMemberId());
		System.out.println("PW : " + member.getMemberPw());
		System.out.println("Phone : " + member.getMemberPhone());
		System.out.println("Grade : "
				+ (member.getMemberGrade().equals("N") ? "일반회원" : member.getMemberId().equals("V") ? "관리자" : "VIP"));
	}

	// 5. 게임팩 대여, 반납 => service에서 if문 써서 대여 현황이 N이면 Y로, Y면 N로 바꿔주기
	public void rentalGame() {
		System.out.println("게임팩 대여 및 반납");
		System.out.println("1. 대여 | 2. 반납");
		int rMenu = Integer.parseInt(sc.nextLine());

		Game game = new Game();

		System.out.println("게임 ID>");
		String gameId = sc.nextLine();

		System.out.println("회원 ID>");
		String memId = sc.nextLine();

		game.setGameId(gameId);
		game.setMemberId(memId);

		int result = MemberDAO.getInstance().rentalGame(game, rMenu);

		if (rMenu == 1) {
			if (game.getGameStatus().equals("Y")) {
				System.out.println("이미 대여된 게임팩 입니다.");
			} else if (result > 0) {
				System.out.println("게임팩 대여 완료");
			} else {
				System.out.println("게임팩 대여 실패");
			}
		} else if (rMenu == 2) {
			if (game.getGameStatus().equals("N")) {
				System.out.println("이미 반납된 게임팩 입니다.");
			} else if (result > 0) {
				System.out.println("게임팩 반납 완료");
			} else {
				System.out.println("게임팩 반납 실패");
			}
		}
	}

//		if(rMenu == 1) {
//			if (result > 0) {
//				System.out.println("게임팩 대여 완료");
//			} else {
//				System.out.println("게임팩 대여 실패");
//			}
//		}else if(rMenu == 2) {
//			if (result > 0) {
//				System.out.println("게임팩 반납 완료");
//			} else {
//				System.out.println("게임팩 반납 실패");
//			}
//		}
//	}

	// 6. 게임팩조회 => 대여여부, 남은 대여일수 알수 있도록 service에서 구성
	// 내가 대여 중인 게임팩
	public void getMyGame() {
		List<Game> list = MemberDAO.getInstance().getMyGame();
		System.out.println("내가 대여 중인 게임팩 조회");
		if (list.size() == 0) {
			System.out.println("대여 중인 게임팩이 없습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("게임번호 : " + list.get(i).getGameId());
				System.out.println("게임명: " + list.get(i).getGameName());
				System.out.println("대여시작 : " + list.get(i).getStart());
				System.out.println("대여종료 : " + list.get(i).getEnd());
				System.out.println("대여여부: " + list.get(i).getGameStatus());
				System.out.println("빌린회원 : " + list.get(i).getMemberId());
				System.out.println("남은 대여 일수 : " + list.get(i).getLeft());
			}
		}
	}

	// 게임팩 전체 조회
	public void getGameInfo() {
		List<Game> list = MemberDAO.getInstance().getGameInfo();
		System.out.println("전체 게임팩 조회");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("게임번호 : " + list.get(i).getGameId());
			System.out.println("게임명: " + list.get(i).getGameName());
			System.out.println("대여시작 : " + list.get(i).getStart());
			System.out.println("대여종료 : " + list.get(i).getEnd());
			System.out.println("대여여부: " + list.get(i).getGameStatus());
			System.out.println("빌린회원 : " + list.get(i).getMemberId());
			System.out.println("남은 대여 일수 : " + list.get(i).getLeft());

			// 리뷰 조회
			System.out.println("🎀🎀🎀🎀🎀🎀🎀🎀🎀리 뷰🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀");
			List<Review> rList = MemberDAO.getInstance().Review();
			if (rList.size() == 0) {
				System.out.println("리뷰가 없습니다.");
			} else {
				for (int r = 0; r < rList.size(); r++) {
					System.out.println("작성자 : " + rList.get(r).getMemberId());
					System.out.println("내용 : " + rList.get(r).getText());
				}
				System.out.println("🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀");
			}
			System.out.println("1. 리뷰 입력 | 2. 리뷰 수정 | 3. 리뷰 삭제");
			int rMenu = Integer.parseInt(sc.nextLine());
			Review review = new Review();
			if (rMenu == 1) {
				// 리뷰 입력

				System.out.println("리뷰 입력");
				System.out.println("작성자>");
				String writer = sc.nextLine();
				System.out.println("리뷰 입력>");
				String text = sc.nextLine();

				review.setMemberId(writer);
				review.setText(text);
				
				int result = MemberDAO.getInstance().insertReview(review);

				if (result > 0) {
					System.out.println("리뷰 등록 성공");
				} else {
					System.out.println("리뷰 등록 실패");
				}
			} else if (rMenu == 2) {
				// 리뷰 수정
				System.out.println("리뷰 수정");
				System.out.println("작성자>");
				String writer = sc.nextLine();
				if(memberInfo.equals(writer)) {
				System.out.println("수정할 리뷰 입력>");
				String text = sc.nextLine();

				review.setMemberId(writer);
				review.setText(text);

				int result = MemberDAO.getInstance().changeReview(review);

				if (result > 0) {
					System.out.println("리뷰 수정이 완료되었습니다.");
				} else {
					System.out.println("리뷰가 수정되지 않았습니다.");
				}
				}else {
					System.out.println("권한이 없는 사용자입니다.");
				}
			} else if (rMenu == 3) {
				
				// 리뷰 삭제
				System.out.println("리뷰 삭제");
				System.out.println("내 리뷰 삭제하기>");
				String writer = sc.nextLine();

				review.setMemberId(writer);

				int result = MemberDAO.getInstance().deleteReview(writer);

				if (result > 0) {
					System.out.println("리뷰가 삭제되었습니다.");
				} else {
					System.out.println("리뷰가 삭제되지 않았습니다.");
				}
			}
		}
	}

	// 게임팩 단건 조회
	public void getGame() {
		System.out.println("게임번호>");
		String gameId = sc.nextLine();
		Game game = MemberDAO.getInstance().getGame(gameId);

		if (game != null) {
			System.out.println("게임번호 : " + game.getGameId());
			System.out.println("게임명: " + game.getGameName());
			System.out.println("대여시작 : " + game.getStart());
			System.out.println("대여종료 : " + game.getEnd());
			System.out.println("대여여부: " + game.getGameStatus());
			System.out.println("빌린회원 : " + game.getMemberId());
			System.out.println("남은 대여 일수 : " + game.getLeft());
		} else {
			System.out.println("조회된 게임 정보가 없습니다.");
		}
	}

	// 7. 회원정보 수정 - 비밀번호 수정, 연락처 수정
	public void changePw() {
		System.out.println("비밀번호 수정");

		Member member = new Member();

		System.out.println("ID>");
		String id = sc.nextLine();
		String pw = "";

		while (true) {
			System.out.println("PW>");
			pw = sc.nextLine();
			if (pw.length() == 0) {
				System.out.println("비밀번호를 입력해주세요.");
			} else {
				System.out.println("비밀번호 확인 완료!");
				break;
			}
		}
		member.setMemberId(id);
		member.setMemberPw(pw);
		int result = MemberDAO.getInstance().changePw(member);

		if (result > 0) {
			System.out.println("비밀번호 수정 완료!");
		} else {
			System.out.println("비밀번호 수정 실패ㅠㅠ");
		}
	}

	public void changePhone() {
		System.out.println("연락처 수정");

		Member member = new Member();

		System.out.println("ID>");
		String id = sc.nextLine();
		String phone = "";

		while (true) {
			System.out.println("연락처>");
			phone = sc.nextLine();
			if (phone.length() > 13) {
				System.out.println("자리수 초과! 13자리수내로 입력해 주세요~");
			} else {
				System.out.println("연락처 확인 완료");
				break;
			}
		}
		member.setMemberId(id);
		member.setMemberPhone(phone);
		int result = MemberDAO.getInstance().changePhone(member);

		if (result > 0) {
			System.out.println("연락처 수정 완료!");
		} else {
			System.out.println("연락처 수정 실패ㅠㅠ");
		}
	}
}
