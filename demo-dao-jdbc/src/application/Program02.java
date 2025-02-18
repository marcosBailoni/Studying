package application;

import java.util.List;

import db.DB;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program02 {

	public static void main(String[] args) {
		
		//Testes do DepartmentDaoJDBC
		
		
		
		DepartmentDao dep = new DepartmentDaoJDBC(DB.getConnection());
		
		//dep insert
//		dep.insert(new Department(null, "teste"));
//		dep.insert(new Department(null, "testeToDelete"));
		
		Department depTeste = dep.findById(9);
		
		depTeste.setName("testeRenamed");
		//depupdate
		dep.update(depTeste);
		
//		dep.deleteById(13);
		
		List<Department> lista1 = dep.findAll();
		for (Department department : lista1) {
			System.out.println(department);
		}
		
		
		DB.closeConnection();
	}
}
