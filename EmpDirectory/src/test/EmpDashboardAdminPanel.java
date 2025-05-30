package test;

import javax.swing.*;

import DAO.EmployeeDAO;
import Model.Employee;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import java.util.List;

public class EmpDashboardAdminPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
    private JPanel listPanel;
    private Connection conn;
    public EmpDashboardAdminPanel() {
		
//		setBackground(new Color(230, 230, 250));
    	setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Employee Dashboard");
		lblNewLabel.setFont(new Font("Pyidaungsu", Font.PLAIN, 25));
		lblNewLabel.setBounds(103, 39, 329, 29);
		add(lblNewLabel);

		textField = new JTextField("Search by Name or Dept");
		textField.setBounds(103, 97, 413, 37);
		add(textField);
		textField.setColumns(10);

		// Placeholder behavior
		textField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals("Search by Name or Dept")) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (textField.getText().isEmpty()) {
					textField.setForeground(Color.GRAY);
					textField.setText("Search by Name or Dept");
				}
			}
		});
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 0, 0));
		btnSearch.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnSearch.setBounds(526, 97, 85, 37);
		add(btnSearch);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(255, 0, 0));
		btnAdd.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnAdd.setBounds(632, 97, 85, 37);
		
		add(btnAdd);

		listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(listPanel);
		scrollPane.setBounds(103, 150, 600, 400);
		add(scrollPane);
		

		// Load all employees by default
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.getAllEmployees();
        showEmployees(employees);
        
     // Set focus on search text field
        SwingUtilities.invokeLater(() -> textField.requestFocus());
        
     // Search action
        btnSearch.addActionListener(e -> {
            String keyword = textField.getText().trim();
            if (keyword.isEmpty() || keyword.equals("Search by Name or Dept")) {
                JOptionPane.showMessageDialog(this, "Please enter a search term.", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }
            List<Employee> result = dao.searchEmployeesByNameOrDept(keyword);
            showEmployees(result);
        });
    }
     
    private void showEmployees(List<Employee> employees) {
        listPanel.removeAll();
        for (Employee emp : employees) {
            JPanel empPanel = new JPanel(new BorderLayout());
            empPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            empPanel.setBackground(Color.WHITE);
            empPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

            JLabel nameLabel = new JLabel("<html><a href='#'><b>" + emp.getEmpName() + "</b></a><br>" + emp.getDepName() + "</html>");
            nameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            empPanel.add(nameLabel, BorderLayout.CENTER);

            nameLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    // Show employee detail panel or popup
                    JOptionPane.showMessageDialog(EmpDashboardAdminPanel.this, 
                        "Show details for " + emp.getEmpName(), 
                        "Employee Details", 
                        JOptionPane.INFORMATION_MESSAGE);
                    // You can call a new window/panel here
                }
            });
            
            JButton deleteBtn = new JButton("\u274C");
			deleteBtn.setFont(new Font("Arial", Font.PLAIN, 12));
			deleteBtn.setForeground(Color.RED);
			deleteBtn.setContentAreaFilled(false);
			deleteBtn.setBorderPainted(false);
			deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			deleteBtn.setToolTipText("Delete");

            listPanel.add(empPanel);
            listPanel.add(deleteBtn);
            deleteBtn.addActionListener(e -> {
				int confirm = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to delete " + getName() + "?", "Confirm Delete",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					listPanel.remove(empPanel);
					listPanel.revalidate();
					listPanel.repaint();
				}
			});

        }
        listPanel.revalidate();
        listPanel.repaint();
    }
}
