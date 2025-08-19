package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBUtil.Util;
import DTO.ExpenseDTO;

public class ExpenseDAO {
	public void insertExpense(ExpenseDTO expense) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO expense (id, title, amount, category, expense_date, memo) "
				+ "VALUES (expense_seq.NEXTVAL, ?, ?, ?, ?, ?)";

		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, expense.getTitle());
			pstmt.setInt(2, expense.getAmount());
			pstmt.setString(3, expense.getCategory());
			pstmt.setDate(4, new java.sql.Date(expense.getExpenseDate().getTime()));
			pstmt.setString(5, expense.getMemo());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, null);
		}
	}

	// 전체 지출 내역 조회
	public List<ExpenseDTO> getAllExpenses() {
		List<ExpenseDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM expense ORDER BY expense_date DESC";

		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ExpenseDTO dto = new ExpenseDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setAmount(rs.getInt("amount"));
				dto.setCategory(rs.getString("category"));
				dto.setExpenseDate(rs.getDate("expense_date"));
				dto.setMemo(rs.getString("memo"));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}

		return list;
	}
}
