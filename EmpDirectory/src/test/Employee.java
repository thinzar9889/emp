package test;

import Config.date;

public class Employee {
    private String emp_id;
    private String empName;
    private String email;
    private date hiringDate;
    private boolean isManager;
    private boolean isActive;
    private boolean isAgreement;
    private String dep_id;
    private String post_id;
    private String password;
    private String dep_name;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	// Constructor with common fields
		public Employee(String emp_id, String empName, String dep_name) {
			this.emp_id = emp_id;
			this.empName = empName;
			this.dep_name = dep_name;
		}

	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public date getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(date hiringDate) {
		this.hiringDate = hiringDate;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isAgreement() {
		return isAgreement;
	}
	public void setAgreement(boolean isAgreement) {
		this.isAgreement = isAgreement;
	}
	public String getDep_id() {
		return dep_id;
	}
	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepName() {
		return dep_name;
	}
	
	public void setDepName(String dep_name) {
		// TODO Auto-generated method stub
		this.dep_name = dep_name;
	}
	
    
}

