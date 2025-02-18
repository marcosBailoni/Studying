package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program03 {

	public static void main(String[] args) {

		// Programa irá alterar algum dado no bd
		// aumentar salário de quem é do departmentId = 2 em 200R$ // ALTER / UPDATE
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE seller " + "SET BaseSalary = BaseSalary + ?" + "WHERE " + "DepartmentId = ?");

			st.setDouble(1, 200);
			st.setInt(2, 2);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Done! Rows affected: " + rowsAffected);
			} else {
				System.out.println("Nothing change");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
