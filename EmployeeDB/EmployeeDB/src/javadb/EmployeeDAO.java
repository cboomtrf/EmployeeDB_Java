package javadb;

import java.sql.*;
import java.util.*;

import model.Employee;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class EmployeeDAO {
	
	private DBaccess db;
	private String TableName = "Employee";

	public EmployeeDAO(DBaccess db) {
		super();
		this.db = db;
	}
	
	public String getTableName() {
		return TableName;
	}

	public void createTable() throws SQLException {
	    String sqlCreate = "CREATE TABLE IF NOT EXISTS " + this.getTableName()
	            + "  (IdEmployee      INTEGER,"
	            + "   firstname       VARCHAR(50),"
	            + "   lastname        VARCHAR(50),"
	            + "   countrycode     VARCHAR(50),"
	            + "   function		      VARCHAR(50))";
	    try {
	    	PreparedStatement ps = db.getStatement(sqlCreate);
	    	db.executeUpdatePreparedStatement(ps);
	    } catch (SQLException e) {
	    	System.out.println("SQL error " + e.getMessage());
	    }
	}
	
	public void storeEmployee(Employee employee) {
		String sql = "insert into Employee(firstname, lastname, countrycode, function) values(?,?,?,?);";
		try {
			PreparedStatement ps = db.getStatementWithKey(sql);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getCountryCode());
			ps.setString(4, employee.getRole());
			int generatedKey = db.executeInsertPreparedStatement(ps);
			employee.setEmployeeId(generatedKey);
			
			System.out.println(employee + " inserted. "
					+ "EmployeeID set to: " + generatedKey);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
	}
	
	public List<Employee> getEmployeeByCountryCode(String code) {
		
		String sql = "Select * from Employee where countrycode = ";
		List<Employee> result = new ArrayList<Employee>();
		try { 
			PreparedStatement ps = db.getStatement(sql);
			ps.setString(1, code);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			
			while (rs.next()) {
				int employeeId = rs.getInt("idEmployee");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String countryCode = rs.getString("countrycode");
				String role = rs.getString("function");
				Employee resultElement = new Employee(employeeId, firstName, lastName, countryCode, role);
				result.add(resultElement);
			}
		}
		catch (SQLException e){
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
	
}
