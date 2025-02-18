package application;

import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program01 {

	public static void main(String[] args) {
		
		//Testes do SellerDaoJDBC
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("------ TEST 1: Seller - findById()\n");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);

		System.out.println("\n------ TEST 2: Seller - findByDepartment()\n");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for (Seller seller2 : list) {
			System.out.println(seller2);
		}
		
		System.out.println("\n------ TEST 3: Seller - findAll()\n");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller seller2 : list2) {
			System.out.println(seller2);
		}
		
		System.out.println("\n------ TEST 4: Seller - Insert()\n");
		Seller s1 = new Seller(null, "Joao", "joao@teste.com", new Date(), 3000.0, dep);
		sellerDao.insert(s1);
		
		System.out.println("\n------ TEST 5: Seller - UPDATE()\n");
		seller = sellerDao.findById(19);
		seller.setName("XandãoMudeiONome");
		sellerDao.update(seller);
		System.out.println("Change name: OK");
		
		System.out.println("\n------ TEST 6: Seller - DELETE()\n");
		sellerDao.deleteById(23);
		System.out.println("Delete ok!!");
		
		DB.closeConnection();
	}
}
