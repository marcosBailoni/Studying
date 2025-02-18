package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program02 {
	
	public static void main(String[] args) {
		//CREATE
		//Programa irá inserir dados no bd// INSERT / CREATE
		
		Connection conn = null;
		PreparedStatement st = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(     //Comando SQL
					"INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) " 
					+ "VALUES " 
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			
			st.setString(1, "Xandão");
			st.setString(2, "xandao@gmail.com");
			st.setDate(3, new Date(sdf.parse("18/11/2024").getTime()));
			st.setDouble(4, 3000);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate(); // retorna linhas afetadas (int) 
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys(); // restorna um ResultSet
				
				System.out.println("Rows Affected: " + rowsAffected);
				while (rs.next()) {
					System.out.println("Created Id: " + rs.getInt(1)); 
				}
			} else {
				System.out.println("Nothing change!!!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();			
		} 
		catch (ParseException e) {			
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}	
	}

}
