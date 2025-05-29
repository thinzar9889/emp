package View;

import javax.swing.*;

import Model.Employee;

import java.awt.*;

public class EmployeeView extends JFrame {
    public JTextField searchField = new JTextField(20);
    public JButton searchButton = new JButton("Search");
    public JButton addButton = new JButton("ADD");
    JButton logoutButton = new JButton("Log out");
    JPanel listPanel = new JPanel();

    public EmployeeView() {
        setTitle("Employee Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);
        topPanel.add(logoutButton);

        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listPanel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void refreshEmployeeList(java.util.List<Employee> employees, java.util.function.Consumer<Employee> onDelete, java.util.function.Consumer<Employee> onDetail) {
        listPanel.removeAll();
        for (Employee emp : employees) {
            JPanel empPanel = new JPanel(new BorderLayout());
            JLabel nameLabel = new JLabel("<html><b>" + emp.getEmpName() + "</b><br>" + emp.getDepName() + "</html>");
            nameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            nameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    onDetail.accept(emp);
                }
            });

            JButton deleteButton = new JButton("🗑");
            deleteButton.addActionListener(e -> onDelete.accept(emp));

            empPanel.add(nameLabel, BorderLayout.CENTER);
            empPanel.add(deleteButton, BorderLayout.EAST);
            listPanel.add(empPanel);
        }
        listPanel.revalidate();
        listPanel.repaint();
    }
}
