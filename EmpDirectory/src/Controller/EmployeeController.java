package Controller;

import DAO.EmployeeDAO;
import Model.Employee;
import View.EmpDashboardAdminView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

public class EmployeeController {
    private EmpDashboardAdminView view;
    private EmployeeDAO dao;

    public EmployeeController(EmpDashboardAdminView view, EmployeeDAO dao) {
        this.view = view;
        this.dao = dao;

        view.setSearchAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String keyword = view.getSearchText();
                loadEmployees(keyword);
            }
        });

        loadEmployees("");
    }

    public void loadEmployees(String keyword) {
        try {
            List<Employee> employees = keyword.isEmpty() ? dao.getAllEmployees() : dao.searchEmployees(keyword);
            view.updateTable(employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

