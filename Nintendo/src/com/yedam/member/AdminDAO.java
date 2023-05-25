package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.game.Game;

public class AdminDAO extends DAO {
	public static AdminDAO adminDao = null;

	private AdminDAO() {

	}

	public static AdminDAO getInstance() {
		if (adminDao == null) {
			adminDao = new AdminDAO();
		}
		return adminDao;
	}

//	1. 회원정보 조회
//	-전체 회원 조회 ( ID - PW - 이름 - 연락처 - 회원등급 - 게임팩 대여 시작일 - 게임팩 대여 종료일)
	public List<Member> getMemberInfo() {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select m.member_id, m.member_pw, m.member_name, m.member_phone, m.member_grade, g.game_rental_start, g.game_rental_end\r\n"
					+ "from member m left join game g\r\n" + "on m.member_id = g.member_id\r\n"
					+ "where member_grade not in ('A')";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setStart(rs.getDate("game_rental_start"));
				member.setEnd(rs.getDate("game_rental_end"));

				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

//	-등급별 조회(일반회원, VIP회원)
	public List<Member> getMember(int cmd) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "";

			if (cmd == 1) {
				sql = "select * from member where member_grade = 'N'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					member = new Member();
					member.setMemberId(rs.getString("member_id"));
					member.setMemberPw(rs.getString("member_pw"));
					member.setMemberName(rs.getString("member_name"));
					member.setMemberPhone(rs.getString("member_phone"));
					member.setMemberGrade(rs.getString("member_grade"));

					list.add(member);
				}
			} else if (cmd == 2) {
				sql = "select * from member where member_grade = 'V'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					member = new Member();
					member.setMemberId(rs.getString("member_id"));
					member.setMemberPw(rs.getString("member_pw"));
					member.setMemberName(rs.getString("member_name"));
					member.setMemberPhone(rs.getString("member_phone"));
					member.setMemberGrade(rs.getString("member_grade"));

					list.add(member);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
//	-회원 등급 수정
	public int modifyGrade(Member member, int cmd) {
		int result = 0;
		try {
			conn();
			if(cmd == 1) {
			String sql = "update member set member_grade = 'V' where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			
			result = pstmt.executeUpdate();
			}else if(cmd == 2) {
				String sql = "update member set member_grade = 'N' where member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberId());
				
				result = pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

//	2. 게임팩 조회
//	-전체조회
	public List<Game> getGameInfo() {
		List<Game> list = new ArrayList<>();
		Game game = null;
		try {
			conn();
			String sql = "select g.game_id, g.game_name, g.game_rental_start, g.game_rental_end, g.game_status,\r\n"
					+ "    m.member_id, TO_CHAR(game_rental_end - game_rental_start) as left\r\n"
					+ "from game g left join member m\r\n" + "on g.member_id = m.member_id\r\n" + "order by game_id";
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

//	-단건조회
	public Game getGame(String gameId) {
		Game game = null;
		try {
			conn();
			String sql = "select g.game_id, g.game_name, g.game_rental_start, g.game_rental_end, g.game_status,\r\n"
					+ "    m.member_id, TO_CHAR(game_rental_end - game_rental_start) as left\r\n"
					+ "from game g left join member m\r\n" + "on g.member_id = m.member_id\r\n" + "where game_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gameId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				game = new Game();
				game.setGameId(rs.getString("game_id"));
				game.setGameName(rs.getString("game_name"));
				game.setStart(rs.getDate("game_rental_start"));
				game.setEnd(rs.getDate("game_rental_end"));
				game.setGameStatus(rs.getString("game_status"));
				game.setMemberId(rs.getString("member_id"));
				game.setLeft(rs.getString("left"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return game;
	}

//	3. 게임팩 관리
//	-게임팩 추가
	public int insertGame(Game game) {
		int result = 0;
		try {
			conn();
			String sql = "insert into game values ('00' || seq_id.nextval, ?, null, null, 'N', null)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, game.getGameName());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

//	-게임팩 삭제
	public int deleteGame(String id) {
		int result = 0;
		try {
			conn();
			String sql = "delete from game where game_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

//	4. 회원 삭제(회원 아이디 입력시)
	public int deleteMember(String id) {
		int result = 0;
		try {
			conn();
			String sql = "delete from member where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
