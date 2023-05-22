package com.yedam.account;

import com.yedam.common.DAO;
import com.yedam.member.Member;

public class AccountDAO extends DAO {

	private static AccountDAO aDao = null;

	private AccountDAO() {

	}

	public static AccountDAO getInstance() {
		if (aDao == null) {
			aDao = new AccountDAO();
		}
		return aDao;
	}

	// 1.고객등록
	public int insertMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO member VALUES (?,?,?,'N')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 2.계좌개설
	public int insertAccount(Account account) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO account VALUES (?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAccountId());
			pstmt.setInt(2, account.getAccountBalance());
			pstmt.setString(3, account.getMemberId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 3. 입출금
	public int inoutMoney(Account account, int cmd) {
		int result = 0;
		try {
			conn();
			// cmd에 따른 입금, 출금 구분
			// 통장 잔고를 확인하는 sql
			String sql2 = "select account_balance from account where account_id = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, account.getAccountId());

			rs = pstmt.executeQuery();

			// 잔고를 담는 변수
			int balance = 0;
			if (rs.next()) {
				balance = rs.getInt("account_balance");
			}

			String sql = "";
			if (cmd == 1) { // 예금
				sql = "update account set account_balance = account_balance + ? where account_id = ?";
			} else if (cmd == 2) { // 출금
				if (balance < account.getAccountBalance()) {
					sql = null;
				} else {
					sql = "update account set account_balance = account_balance - ? where account_id = ?";
				}
			}
			if (sql == null) {
				// 예금액 < 출금액 예외 처리
				System.out.println("예금액보다 출금액이 많습니다. 출금 실패!!");
			} else {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, account.getAccountBalance());
				pstmt.setString(2, account.getAccountId());
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 4. 계좌 이체
	public int transferMoney(String toAccount, String fromAccount, int balance) {
		// toAccount => 받는 사람의 계좌
		// fromAccount => 보내는 사람의 계좌
		// balance => 송금하는 금액
		int result = 0;
		try {
			conn();
			// 1. 보내는 계좌에서 금액 차감
			String sql = "update account set account_balance = account_balance - ? where account_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, fromAccount);

			result = pstmt.executeUpdate();

			if (result == 1) { // 왜 1, 0 이지?????????????????????????
				System.out.println("정상 이체");
			} else {
				System.out.println("이체 실패");
			}
			// 2. 받는 계좌 금액 증가
			sql = "update account set account_balance = account_balance + ? where account_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, toAccount);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 5. 계좌 해지
	public int deleteAccount(String accountId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from account where account_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
