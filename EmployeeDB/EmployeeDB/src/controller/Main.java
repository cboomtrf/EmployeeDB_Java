package controller;

import java.util.*;

import javadb.DBaccess;
import javadb.EmployeeDAO;
import model.Employee;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class Main {

	private DBaccess db;
	private EmployeeDAO dao;

	public Main() {
		super();
		db = new DBaccess();
		dao = new EmployeeDAO(db);
	}

	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}

	private void run() {
	
		try {
			db.openConnection();
			System.out.println("Connection open");
			dao.createTable();
		} 
		catch (Exception e) {
			System.out.println("\nEr is iets fout gegaan\n");
			e.printStackTrace();
		}
		
		
//		Create an Employee object and save in the database.
		Employee hardWorker = new Employee("Hard", "Worker", "NL", "Administrator");
		dao.storeEmployee(hardWorker);
		
//		Receive the employees from country code NL from the database and print all.
		List<Employee> empCountry = dao.getEmployeeByCountryCode("NL");
		for (Employee e : empCountry) {
			System.out.println(e);
		}
		
		db.closeConnection();

	}
}
