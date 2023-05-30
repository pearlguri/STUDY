package com.yedam.game;

import com.yedam.common.DAO;

public class GameDAO extends DAO {
	public static GameDAO gameDao = null;

	private GameDAO() {

	}

	public static GameDAO getInstance() {
		if (gameDao == null) {
			gameDao = new GameDAO();
		}
		return gameDao;
	}

	public int Gamenum(String gameId) {
		int result = 0;
		try {
			conn();
			String sql = "select g_num from game where game_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gameId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt("g_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
