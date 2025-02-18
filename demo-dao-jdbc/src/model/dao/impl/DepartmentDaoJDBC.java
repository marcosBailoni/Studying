package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {			
			st = conn.prepareStatement(
					"INSERT into department "
					+ "(Name) "
					+ "VALUES "
					+ "(?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			
			int rA = st.executeUpdate();
			
			if (rA > 0 ) {
				rs = st.getGeneratedKeys();
				
				if(rs.next()) {
					obj.setId(rs.getInt(1));
					System.out.println("Department created!! Id: " + obj.getId());
				}
				else {
					throw new DBException("Error to Create!!");
				}
				
			}
		}
		catch(SQLException e ) {
			throw new DBException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE Department "
					+ "SET Name = ? "
					+ "WHERE Id = ? ");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					 "DELETE FROM department WHERE Id = ?");
			st.setInt(1, id);
			
			int rowsAf = st.executeUpdate();
			
			if(rowsAf > 0) {
				System.out.println("Sucess!!! Rows Affected: " + rowsAf );
			}else if(rowsAf == 0) {
				throw new DBException("ID not found");
				
			} else {
				throw new DBException("Nothing Change");
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}		

	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;  
	    
	    try {
	    	st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
	    	st.setInt(1, id);
	    	
	    	ResultSet rs = st.executeQuery();
	    	
	    	if (rs.next()) {
	            Department depTemp = new Department(rs.getInt("Id"), rs.getString("Name"));
	            return depTemp; // Retorna um Optional com o valor encontrado
	        }
	    	
	    	DB.closeResultSet(rs);	    	
	    }
	    catch (SQLException e) {
	        throw new DBException(e.getMessage());
//	        e.printStackTrace();
	    }
	    finally {
	    	DB.closeStatement(st);
	    }
	    return null;	    
	}

	@Override
	public List<Department> findAll() {
		List<Department> deps = new ArrayList<Department>();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department");
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				deps.add(new Department(rs.getInt("Id"), rs.getString("Name")));
			}
			
		}
		catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		
		return deps;
	}

}
