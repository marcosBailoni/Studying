package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program01 {

	public static void main(String[] args) {
		// READ
		// Programa irá ler os registros do banco de dados: CONSULTAS

		Connection conn = null; // conexão com bd
		Statement st = null; // executar querys / comandos pro bd
		ResultSet rs = null; // registrar os resultados do st e resgatar valores

		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from seller");

			while (rs.next()) {
				System.out.println(
						"Id: " + rs.getInt("Id") + ", Name: " + rs.getString("Name") 
						+ ", DepartmentId: " + rs.getInt("DepartmentId") 
						+ ", Salary: " + rs.getDouble("BaseSalary"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}

	}
}
