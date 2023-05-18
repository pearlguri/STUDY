package com.yedam.employees;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class EmployeesDAO extends DAO {

	// 싱글톤 -> DB에 접속
	private static EmployeesDAO empDao = null;

	private EmployeesDAO() {

	}

	public static EmployeesDAO getInstance() {
		if (empDao == null) {
			empDao = new EmployeesDAO();
		}
		return empDao; // emopDao <-객체
	}

	// 전체 조회
	public List<Employees> getEmployeesList() { // empDao의 메소드
		List<Employees> list = new ArrayList<>();
		Employees emp = null;
		try {
			conn();
			String sql = "SELECT * FROM employees";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				emp = new Employees();
				emp.setEmployeeId(rs.getInt("employee_id")); // 테이블의 컬럼명 X, 조회된 결과의 컬럼명(별칭 설정했다면 별칭을 써야 함)
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getDate("hire_date"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 단건조회(한건 조회)
	public Employees getEmployee(int empid) {
		Employees emp = null;
		try {
			conn();
			String sql = "SELECT * FROM employees WHERE employee_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empid); //첫번째 물음표에 empid를 넣는다!

			rs = pstmt.executeQuery();

			if (rs.next()) {
				emp = new Employees();
				emp.setEmployeeId(rs.getInt("employee_id")); // 테이블의 컬럼명 X, 조회된 결과의 컬럼명(별칭 설정했다면 별칭을 써야 함)
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getDate("hire_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return emp;
	}
	
	//등록(insert)
	public int insertEmp(Employees emp) {
		int result = 0;
		try {
			conn();
			String sql = "insert into employees(employee_id,last_name,email,hire_date,job_id) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.setDate(4, emp.getHireDate());
			pstmt.setString(5, emp.getJobId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

}
