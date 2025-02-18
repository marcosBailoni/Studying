package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	
	// método para conectar o conn no banco e retornar um objeto: Connection

	public static Connection getConnection() {

		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} 
			catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}

		return conn;
	}

//	/-----------------------------------------------------------------------------------------/
	
//	Método para fechar a conexão do conn
	
	public static void closeConnection() {
		if (conn != null) {
			
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	// ---------------------------------------------------------------------------------------//

//	Método para criar uma properties e retorna-la, lendo o arquivo 
	
	private static Properties loadProperties() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();

			props.load(fs);
			return props;

		} catch (IOException e) {
			throw new DBException(e.getMessage());
		}

	}
	
	// método para fechar um Statement
	public static void closeStatement(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}
	
	// método para fechar um ResultSet
	public static void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}
}

