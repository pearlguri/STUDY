package com.yedam.coffee;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CoffeeDAO extends DAO {
	private static CoffeeDAO coffeeDao = null;

	private CoffeeDAO() {

	}

	public static CoffeeDAO getInstance() {
		if (coffeeDao == null) {
			coffeeDao = new CoffeeDAO();
		}
		return coffeeDao;
	}

	// 1. 메뉴 조회
	public List<Coffee> getCoffeeList() {
		List<Coffee> list = new ArrayList<>();
		Coffee coffee = null;
		try {
			conn();
			String sql = "select * from coffe";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffee.setCoffeeExplain(rs.getString("coffee_explain"));
				coffee.setCoffeeSales(rs.getInt("coffee_sales"));
				list.add(coffee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 2. 메뉴 상세 조회
	public Coffee getDetailMenu(String coffeeMenu) {
		Coffee coffee = new Coffee();
		try {
			conn();
			String sql = "select * from coffe where coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffeeMenu);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffee.setCoffeeExplain(rs.getString("coffee_explain"));
				coffee.setCoffeeSales(rs.getInt("coffee_sales"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return coffee;
	}

	// 3. 메뉴 등록
	public int insertMenu(Coffee coffee) {
		int result = 0;
		try {
			conn();
			String sql = "insert into coffe values (?,?,?,0)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, coffee.getCoffeeMenu());
			pstmt.setInt(2, coffee.getCoffeePrice());
			pstmt.setString(3, coffee.getCoffeeExplain());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 4. 판매
	public int sellMenu(Coffee coffee) {
		int result = 0;

		try {
			conn();
			String sql = "update coffe set coffee_sales = coffee_sales + 1 where coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee.getCoffeeMenu());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 5. 메뉴 삭제
	public int deleteMenu(String menu) {
		int result = 0;
		try {
			conn();
			String sql = "delete from coffe where coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 6. 매출
	// 1) 데이터 조회 후 java 처리 -> getCoffeeList()
	// 2)DB sum(coffee_price)
	public List<Coffee> sales() {
		List<Coffee> list = new ArrayList<>();
		Coffee coffee = null;
		try {
			conn();
			String sql = "select * from coffe";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeeSales(count);
				coffee.setCoffeeSales(rs.getInt("coffee_sales"));
				list.add(coffee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
}
