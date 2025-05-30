package test;

import java.sql.*;
import java.util.*;

import Config.ClsDBConnection;
import Model.Employee;

public class EmployeeDAO {

	private Connection con;

	 public EmployeeDAO() {
	        try {
				this.con = ClsDBConnection.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Ensure it's not null
	    }

	// Get all employees from the database
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT e.emp_id, e.empName, d.dep_name FROM employee e "
                   + "JOIN department d ON e.dep_id = d.dep_id";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Constructor sets emp_id, empName, and dep_name
                Employee emp = new Employee(
                    rs.getString("emp_id"),
                    rs.getString("empName"),
                    rs.getString("dep_name")
                );
                employees.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

 // Get employee by ID
    public Employee getEmployeeById(String empId) {
        String sql = "SELECT * FROM employee WHERE emp_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, empId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee(
                    rs.getString("emp_id"),
                    rs.getString("empName"),
                    "" // No department name in this query
                );
                emp.setEmail(rs.getString("email"));
                emp.setDep_id(rs.getString("dep_id"));
                emp.setPost_id(rs.getString("post_id"));
                return emp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	public List<Employee> searchEmployeesByNameOrDept(String keyword) {
	    List<Employee> list = new ArrayList<>();
	    String sql = "SELECT * FROM employee e JOIN department d ON e.dep_id = d.dep_id " +
	                 "WHERE e.empName LIKE ? OR d.dep_name LIKE ?";
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, "%" + keyword + "%");
	        ps.setString(2, "%" + keyword + "%");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Employee emp = new Employee();
	            emp.setEmp_id(rs.getString("emp_id"));
	            emp.setEmpName(rs.getString("empName"));
	            emp.setDepName(rs.getString("dep_name")); // Add this to Employee class
	            list.add(emp);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	public void deleteEmployee(String emp_id) {
		String sql = "DELETE FROM employee WHERE emp_id = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, emp_id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}