package model;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class Employee {
	
	private int employeeId; 
	private String firstName;
	private String lastName;
	private String countryCode;
	private String role;
	
	public Employee(String firstName,String lastName, String countryCode, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryCode = countryCode;
		this.role = role;
	}
	
	public Employee(int employeeId, String firstName,String lastName, String countryCode, String role) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryCode = countryCode;
		this.role = role;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		return "[" + employeeId + ", " + firstName + ", " + lastName + ", " + countryCode + ", " + role + "]" ;
		
	}
}
