package View;

import Model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Employee;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class EmpDashboardAdminView1 extends JFrame {
    private JTextField txtSearch;
    private JButton btnSearch, btnLogout;
    private JTable table;
    private DefaultTableModel model;

    public EmpDashboardAdminView1() {
        setTitle("Employee Dashboard");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        txtSearch = new JTextField("Search by Name or Dept");
        txtSearch.setForeground(Color.GRAY);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtSearch.getText().equals("Search by Name or Dept")) {
                    txtSearch.setText("");
                    txtSearch.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtSearch.getText().isEmpty()) {
                    txtSearch.setForeground(Color.GRAY);
                    txtSearch.setText("Search by Name or Dept");
                }
            }
        });

        btnSearch = new JButton("Search");
        btnLogout = new JButton("Log out");

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(txtSearch, BorderLayout.CENTER);
        searchPanel.add(btnSearch, BorderLayout.EAST);

        topPanel.add(searchPanel, BorderLayout.CENTER);
        topPanel.add(btnLogout, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {"Name", "Department", "Action"};
        model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        table = new JTable(model);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        txtSearch.requestFocusInWindow();
    }

    public void setSearchAction(ActionListener listener) {
        btnSearch.addActionListener(listener);
    }

    public String getSearchText() {
        String text = txtSearch.getText();
        return text.equals("Search by Name or Dept") ? "" : text.trim();
    }

    public void updateTable(List<Employee> employees) {
        model.setRowCount(0);
        for (Employee emp : employees) {
            JButton deleteBtn = new JButton("🗑");
            model.addRow(new Object[]{emp.getName(), emp.getDepartment(), deleteBtn});
        }
    }
}
