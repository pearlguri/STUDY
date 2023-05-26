package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.game.Game;
import com.yedam.review.Review;

public class MemberDAO extends DAO {
	private static MemberDAO memberDao = null;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (memberDao == null) {
			memberDao = new MemberDAO();
		}
		return memberDao;
	}

	// 1. 로그인
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberGrade(rs.getString("member_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}

	// 2. 회원가입
	public int insertMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into member values('user' || seq_member.nextval, ?, ?, ?, 'N')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getMemberPhone());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// memberInfo로 service에서 처리함.
//	// 3. 정보조회 - ID - PW - 이름 - 연락처 - 회원등급
//	public List<Member> getMemberInfo() {
//		List<Member> list = new ArrayList<>();
//		Member member = new Member();
//		try {
//			conn();
//			String sql = "SELECT * FROM member";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			;
//
//			while (rs.next()) {
//				member.setMemberId(rs.getString("member_id"));
//				member.setMemberPw(rs.getString("member_pw"));
//				member.setMemberName(rs.getString("member_name"));
//				member.setMemberPhone(rs.getString("member_phone"));
//				member.setMemberGrade(rs.getString("member_grade"));
//
//				list.add(member);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		return list;
//	}

	// 4.게임팩 대여, 반납 => service에서 if문 써서 대여 현황이 N이면 Y로, Y면 N로 바꿔주기
	public int rentalGame(Game game, int cmd) {
		int result = 0;
		try {
			conn();
			if (cmd == 1) { // TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE + 20)
				String sql = "UPDATE game SET game_status = 'Y', game_rental_start = TO_CHAR(SYSDATE, 'YYYYMMDD'), game_rental_end = TO_CHAR(SYSDATE + 20), member_id = ?, g_num = g_num - 1 WHERE game_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, game.getMemberId());
				pstmt.setString(2, game.getGameId());

				result = pstmt.executeUpdate();
				
			} else if (cmd == 2) {
				String sql = "UPDATE game SET game_status = 'N', game_rental_start = null, game_rental_end = null, member_id = null, g_num = g_num + 1 WHERE game_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, game.getGameId());

				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 5. 게임팩조회 => 대여여부, 남은 대여일수 알수 있도록 service에서 구성
	// 내가 대여 중인 게임팩
	public List<Game> getMyGame() {
		List<Game> list = new ArrayList<>();
		Game game = null;
		try {
			conn();
			String sql = "select g.game_id, g.game_name, g.game_rental_start, g.game_rental_end, g.game_status,\r\n"
					+ "    m.member_id, TO_CHAR(game_rental_end - game_rental_start) as left\r\n"
					+ "from game g join member m\r\n" + "on g.member_id = m.member_id\r\n" + "order by game_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				game = new Game();
				game.setGameId(rs.getString("game_id"));
				game.setGameName(rs.getString("game_name"));
				game.setStart(rs.getDate("game_rental_start"));
				game.setEnd(rs.getDate("game_rental_end"));
				game.setGameStatus(rs.getString("game_status"));
				game.setMemberId(rs.getString("member_id"));
				game.setLeft(rs.getString("left"));

				list.add(game);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 전체조회
	public List<Game> getGameInfo() {
		List<Game> list = new ArrayList<>();
		Game game = null;
		try {
			conn();
			String sql = "select g.game_id, g.game_name, g.g_num, g.game_rental_start, g.game_rental_end, g.game_status,\r\n"
					+ "    m.member_id, TO_CHAR(game_rental_end - game_rental_start) as left\r\n"
					+ "from game g left join member m\r\n" + "on g.member_id = m.member_id\r\n" + "order by game_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				game = new Game();
				game.setGameId(rs.getString("game_id"));
				game.setGameName(rs.getString("game_name"));
				game.setGNum(rs.getInt("g_num"));
				game.setStart(rs.getDate("game_rental_start"));
				game.setEnd(rs.getDate("game_rental_end"));
				game.setGameStatus(rs.getString("game_status"));
				game.setMemberId(rs.getString("member_id"));
				game.setLeft(rs.getString("left"));

				list.add(game);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 단건조회
	public Game getGame(String gameId) {
		Game games = null;
		try {
			conn();
			String sql = "select g.game_id, g.game_name, g.g_num, g.game_rental_start, g.game_rental_end, g.game_status,\r\n"
					+ "    m.member_id, TO_CHAR(game_rental_end - game_rental_start) as left\r\n"
					+ "from game g left join member m\r\n" + "on g.member_id = m.member_id\r\n" + "where game_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gameId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				games = new Game();
				games.setGameId(rs.getString("game_id"));
				games.setGameName(rs.getString("game_name"));
				games.setGNum(rs.getInt("g_num"));
				games.setStart(rs.getDate("game_rental_start"));
				games.setEnd(rs.getDate("game_rental_end"));
				games.setGameStatus(rs.getString("game_status"));
				games.setMemberId(rs.getString("member_id"));
				games.setLeft(rs.getString("left"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return games;
	}

	// 리뷰 조회
	public List<Review> Review() {
		List<Review> list = new ArrayList<>();
		Review review = null;
		try {
			conn();
			String sql = "select r.* from review r left join game g on r.game_id = g.game_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				review = new Review();
				review.setReviewId(rs.getString("review_id"));
				review.setMemberId(rs.getString("member_id"));
				review.setText(rs.getString("text"));

				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 리뷰 입력
	public int insertReview(Review review) {
		int result = 0;
		try {
			conn();
			String sql = "insert into review values(seq_review.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getMemberId());
			pstmt.setString(2, review.getText());
			pstmt.setString(3, review.getGameId());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 리뷰 수정
	public int changeReview(Review review) {
		int result = 0;
		try {
			conn();
			String sql = "update review set text = ? where member_id = ? and review_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getText());
			pstmt.setString(2, review.getMemberId());
			pstmt.setString(3, review.getReviewId());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 리뷰 삭제
	public int deleteReview(String memberId, String reviewId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from review where member_id = ? and review_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, reviewId);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 별점조회
	// 별점등록
	// 별점수정
	// 별점삭제

	// 6. 회원정보 수정 - 비밀번호 수정, 연락처 수정
	public int changePw(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_pw = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberId());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	public int changePhone(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_phone = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPhone());
			pstmt.setString(2, member.getMemberId());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	 
}
