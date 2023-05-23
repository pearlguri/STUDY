package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.game.Game;

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
			String sql = "INSERT INTO member VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberGrade());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 3. 정보조회 - ID - PW - 이름 - 연락처 - 회원등급
	public List<Member> getMemberInfo() {
		List<Member> list = new ArrayList<>();
		Member member = new Member();
		try {
			conn();
			String sql = "SELECT * FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			;

			while (rs.next()) {
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberGrade(rs.getString("member_grade"));

				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 4. 게임팩조회 - 전체조회, 단건조회 => 대여여부, 남은 대여일수 알수 있도록 service에서 구성
	public List<Game> getGameInfo() {
		List<Game> list = new ArrayList<>();
		Game game = null;
		try {
			conn();
			String sql = "SELECT * FROM game";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				game.setGameId(rs.getString("game_id"));
				game.setGameName(rs.getString("game_name"));
				game.setStart(rs.getDate("game_rental_start"));
				game.setEnd(rs.getDate("game_rental_end"));
				game.setGameStatus(rs.getString("game_status"));
				game.setMemberId(rs.getString("member_id"));

				list.add(game);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	public Game getGame(String gameId) {
		Game games = null;
		try {
			conn();
			String sql = "SELECT * FROM game WHERE game_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gameId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				games = new Game();
				games.setGameId(rs.getString("game_id"));
				games.setGameName(rs.getString("game_name"));
				games.setStart(rs.getDate("game_rental_start"));
				games.setEnd(rs.getDate("game_rental_end"));
				games.setGameStatus(rs.getString("game_status"));
				games.setMemberId(rs.getString("member_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return games;
	}

	// 5.게임팩 대여, 반납 => service에서 if문 써서 대여 현황이 N이면 Y로, Y면 N로 바꿔주기
	public int rentalGame(Game gameId) {
		int result = 0;
		try {
			conn();
			Game game = new Game();
			if (game.getGameStatus().equals('N')) {
				String sql = "UPDATE game SET game_status = 'Y' WHERE game_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, gameId.getGameId());

				result = pstmt.executeUpdate();
			} else if (game.getGameStatus().equals('Y')) {
				String sql = "UPDATE game SET game_status = 'N' WHERE game_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, gameId.getGameId());

				result = pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 6. 회원정보 수정 - 비밀번호 수정, 연락처 수정
	public int changePw(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_pw = ? WHERE memberid = ?";
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
			String sql = "UPDATE member SET member_phone = ? WHERE memberid = ?";
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
