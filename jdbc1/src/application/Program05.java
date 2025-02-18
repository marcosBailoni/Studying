package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

public class Program05 {

	// Programa fará transações usando rollback / commit

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try { 
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			conn.setAutoCommit(false); // As alterações ficarão pendentes até confirmação 
			
			st.executeUpdate("UPDATE seller SET BaseSalary = BaseSalary / 2.5 WHERE Id = 1");
			
			
			// exception abaixo serve para quebrar o fluxo, como teste, pra testar o catch/rollback
//			int x = 0;
			
//			if (x != 1) {
//				throw new SQLException("Fake error");
//			}					
			
			st.executeUpdate("UPDATE seller SET BaseSalary = 2000 WHERE Id = 2");			
		
			conn.commit(); // Confirma as alterações;
		}
		catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transaction rolled back! Caused by: " + e.getMessage());
			}
			catch(SQLException e1) {
				throw new DBException("Failer Rollback. Caused by: " + e1.getMessage());
			}			
		}		
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}	
		
	}

}
