package DAO;

import Model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT id, name, department FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            list.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
        }
        return list;
    }

    public List<Employee> searchEmployees(String keyword) throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT id, name, department FROM employees WHERE name LIKE ? OR department LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            list.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
        }
        return list;
    }
}
