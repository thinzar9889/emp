import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.EmployeeDAO;
import Model.Employee;
import View.EmployeeView;

public class EmployeeController {
    private EmployeeView view;
    private EmployeeDAO dao;

    public EmployeeController(EmployeeView view, EmployeeDAO dao) {
        this.view = view;
        this.dao = dao;

        view.searchButton.addActionListener(e -> loadEmployees());
        view.addButton.addActionListener(e -> showAddDialog());
        loadEmployees();
    }

    private void loadEmployees() {
        try {
            String keyword = view.searchField.getText().trim();
            List<Employee> list = dao.getAllEmployees(keyword);
            view.refreshEmployeeList(list, this::deleteEmployee, this::showEmployeeDetails);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Failed to load employees: " + e.getMessage());
        }
    }

    private void deleteEmployee(Employee emp) {
        try {
            dao.deleteEmployee(emp.getEmp_id());
            loadEmployees();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Failed to delete: " + e.getMessage());
        }
    }

    private void showAddDialog() {
        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        int option = JOptionPane.showConfirmDialog(view, new Object[]{"Name:", nameField, "Department:", deptField}, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                dao.addEmployee(nameField.getText(), deptField.getText());
                loadEmployees();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, "Failed to add: " + e.getMessage());
            }
        }
    }

    private void showEmployeeDetails(Employee emp) {
        JOptionPane.showMessageDialog(view, "Employee Name: " + emp.getEmpName() + "\nDepartment: " + emp.getDepartment());
    }

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdirectory", "username", "password");
        EmployeeDAO dao = new EmployeeDAO(conn);
        EmployeeView view = new EmployeeView();
        new EmployeeController(view, dao);
        view.setVisible(true);
    }

	public void deleteEmployee(String emp_id) {
		// TODO Auto-generated method stub
		
	}

    

}
