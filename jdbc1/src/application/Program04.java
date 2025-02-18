package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program04 {

	public static void main(String[] args) {
		// Programa irá tentar deletar um department do BD
		// no caso abaixo, iremos lancar uma exception de FK, caso tente deletar um department já registrado
		// em algum seller
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ? ");
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0 ) {
				System.out.println("Rows Affected: " + rowsAffected);				
				
			} else {
				System.out.println("Nothing change!!!");
			}
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}		
		
	}		

}
