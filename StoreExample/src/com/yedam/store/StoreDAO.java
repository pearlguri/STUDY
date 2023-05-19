package com.yedam.store;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StoreDAO extends DAO {
	private static StoreDAO storeDao = null;

	private StoreDAO() {

	}

	public static StoreDAO getInstance() {
		if (storeDao == null) {
			storeDao = new StoreDAO();
		}
		return storeDao;
	}

	// 모든 가게 정보 조회
	public List<Store> getStoreList() {
		List<Store> list = new ArrayList<>();
		Store store = null;
		try {
			conn();
			String sql = "SELECT * FROM store";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				store = new Store();
				store.setStore_id(rs.getInt("store_id"));
				store.setStore_name(rs.getString("store_name"));
				store.setStore_tel(rs.getString("store_tel"));
				store.setStore_addr(rs.getString("store_addr"));
				store.setSales(rs.getInt("store_sales"));

				list.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return list;
	}

	// 지역구별 매출 합계
	public List<Store> getStoreSales() {
		List<Store> list = new ArrayList<>();
		Store store = null;
		try {
			conn();
			String sql = "SELECT SUBSTR(store_addr, 4,3) AS location, sum(store_sales) \"loc_sales\"\r\n"
					+ "FROM store\r\n" + "GROUP BY SUBSTR(store_addr,4,3)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				store = new Store();
				store.setStore_addr(rs.getString("location"));
				store.setSales(rs.getInt("loc_sales"));

				list.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 가게 정보 입력
	public int insertStore(Store store) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO store VALUES((SELECT COUNT (*)+1\r\n" + "FROM store), ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// store_id -> 1.데이터 입력 <<2.서브쿼리를 활용해서 자동부여>> 3.시퀀스를 활용해서 자동부여
			pstmt.setString(1, store.getStore_name());
			pstmt.setString(2, store.getStore_tel());
			pstmt.setString(3, store.getStore_addr());
			pstmt.setInt(4, store.getSales());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 매출 수정
	public int updateSales(Store store_id) {
		int result = 0;
		Store store = new Store();
		try {
			conn();
			String sql = "UPDATE store SET store_sales = ? WHERE store_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, store.getSales());
			pstmt.setInt(2, store.getStore_id());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

}
