package View;

import javax.swing.*;

import Model.Employee;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EmpDashboardAdminView extends JFrame {
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private Map<String, JPanel> panels = new LinkedHashMap<>();
    private Map<String, JLabel> navLabels = new LinkedHashMap<>();
    private Color normalColor = Color.BLACK;
    private Color hoverColor = Color.GRAY;
    private Color activeColor = new Color(34, 139, 34); // Forest Green
    private JLabel activeLabel = null;

    public EmpDashboardAdminView() {
        setTitle("Employee Directory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(995, 700);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel menuBar = createMenuBar();
        mainPanel.add(menuBar, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Color.WHITE);

        createPanels();

        for (Map.Entry<String, JPanel> entry : panels.entrySet()) {
            contentPanel.add(entry.getValue(), entry.getKey());
        }

        cardLayout.show(contentPanel, "EmployeeDashboard");
        setActiveNav("Employee Dashboard");

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        getContentPane().add(mainPanel);
    }

    private JPanel createMenuBar() {
        JPanel menuBar = new JPanel(new BorderLayout());
        menuBar.setBackground(new Color(230, 230, 250));
        menuBar.setPreferredSize(new Dimension(getWidth(), 50));
        menuBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        leftPanel.setOpaque(false);

        JLabel systemName = new JLabel("Employee Directory");
        systemName.setFont(new Font("Arial", Font.BOLD, 16));
        systemName.setForeground(Color.BLACK);

        leftPanel.add(systemName);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        navPanel.setOpaque(false);

        String[] menuItems = {"Employee Dashboard", "Admin Dashboard", "Add Admin"};

        for (String item : menuItems) {
            JLabel navLabel = createNavLabel(item);
            navLabels.put(item, navLabel);
            navPanel.add(navLabel);
        }

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightPanel.setOpaque(false);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFocusPainted(false);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(220, 53, 69));
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        logoutButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                logoutButton.setBackground(new Color(200, 35, 50));
            }
            public void mouseExited(MouseEvent e) {
                logoutButton.setBackground(new Color(220, 53, 69));
            }
        });

        logoutButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
                System.exit(0);
            }
        });

        rightPanel.add(logoutButton);

        menuBar.add(leftPanel, BorderLayout.WEST);
        menuBar.add(navPanel, BorderLayout.CENTER);
        menuBar.add(rightPanel, BorderLayout.EAST);

        return menuBar;
    }

    private JLabel createNavLabel(String name) {
        JLabel label = new JLabel(name);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(normalColor);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));

        label.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (label != activeLabel) {
                    label.setForeground(hoverColor);
                }
            }
            public void mouseExited(MouseEvent e) {
                if (label != activeLabel) {
                    label.setForeground(normalColor);
                }
            }
            public void mouseClicked(MouseEvent e) {
                setActiveNav(name);
                cardLayout.show(contentPanel, name.replace(" ", ""));
            }
        });

        return label;
    }

    private void setActiveNav(String name) {
        if (activeLabel != null) {
            activeLabel.setForeground(normalColor);
        }
        activeLabel = navLabels.get(name);
        if (activeLabel != null) {
            activeLabel.setForeground(activeColor);
        }
    }

    private void createPanels() {
        panels.put("EmployeeDashboard", createEmployeeDashboard());
        
        panels.put("AdminDashboard", panelWithLabel("Admin Dashboard"));
        panels.put("AddAdmin", panelWithLabel("Add Admin"));
    }

    private JPanel panelWithLabel(String text) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(text));
        return panel;
    }

    private JPanel createEmployeeDashboard() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(null);
        topPanel.setPreferredSize(new Dimension(995, 60));
        topPanel.setBackground(Color.WHITE);

        JLabel dashboardTitle = new JLabel("Employee Dashboard");
        dashboardTitle.setFont(new Font("Arial", Font.BOLD, 18));
        dashboardTitle.setBounds(20, 0, 300, 30);
        topPanel.add(dashboardTitle);

        
       
        
        
        
        JTextField textField = new JTextField("Search by Name or Dept.");
        textField.setForeground(Color.GRAY);
        textField.setBounds(142, 35, 456, 32);

        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                if (textField.getText().equals("Search by Name or Dept.")) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText("Search by Name or Dept.");
                }
            }
        });

        topPanel.add(textField);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(Color.RED);
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(625, 40, 85, 21);
        topPanel.add(btnSearch);

        JButton btnAdd = new JButton("Add");
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(Color.RED);
        btnAdd.setBounds(738, 40, 85, 21);
        topPanel.add(btnAdd);
        topPanel.setPreferredSize(new Dimension(995, 80));
        
        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gridPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        String[][] employees = {
            {"John Doe", "HR"},
            {"Jane Smith", "IT"},
            {"Alice Johnson", "Finance"},
            {"Bob Lee", "Marketing"},
            {"Emily Davis", "Operations"}
        };

        Runnable updateGrid = () -> {
            gridPanel.removeAll();
            String searchText = textField.getText().trim().toLowerCase();
            for (String[] emp : employees) {
                String name = emp[0];
                String dept = emp[1];
                if (searchText.equals("") ||
                    searchText.equals("search by name or dept.") ||
                    name.toLowerCase().contains(searchText) ||
                    dept.toLowerCase().contains(searchText)) {

                    JLabel nameLabel = new JLabel("<html><a href=''>" + name + "</a></html>");
                    
                    nameLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    nameLabel.setForeground(Color.BLUE);
                    nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));

                    nameLabel.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            setActiveNav("Employee Detail");
                            cardLayout.show(contentPanel, "EmployeeDetail");
                            JPanel detailPanel = panels.get("EmployeeDetail");
                            detailPanel.removeAll();
                            detailPanel.add(new JLabel("Details for: " + name));
                            detailPanel.revalidate();
                            detailPanel.repaint();
                        }
                    });

                    JLabel deptLabel = new JLabel(dept);
                    deptLabel.setFont(new Font("Arial", Font.PLAIN, 14));

//                    ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/View/delete.png"));
//                    JButton deleteBtn = new JButton(deleteIcon);
//                    deleteBtn.setPreferredSize(new Dimension(24, 24));
//                    deleteBtn.setContentAreaFilled(false);
//                    deleteBtn.setBorderPainted(false);
//                    deleteBtn.setFocusPainted(false);
//                    deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                    deleteBtn.setToolTipText("Delete");

                    JButton deleteBtn = new JButton("\u274C");
                    deleteBtn.setFont(new Font("Arial", Font.PLAIN, 12));
                    deleteBtn.setForeground(Color.RED);
                    deleteBtn.setContentAreaFilled(false);
                    deleteBtn.setBorderPainted(false);
                    deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    deleteBtn.setToolTipText("Delete");


                    JPanel empPanel = new JPanel(new BorderLayout());
                    empPanel.setBackground(new Color(245, 245, 245));
                    empPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(200, 200, 200)),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    ));


                    JPanel textPanel = new JPanel(new GridLayout(2, 1));
                    textPanel.setBackground(Color.WHITE);
                    textPanel.add(nameLabel);
                    textPanel.add(deptLabel);

                    empPanel.add(textPanel, BorderLayout.CENTER);
                    empPanel.add(deleteBtn, BorderLayout.EAST);
                    
                    deleteBtn.addActionListener(e -> {
                        int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure you want to delete " + name + "?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                        );
                        if (confirm == JOptionPane.YES_OPTION) {
                            gridPanel.remove(empPanel);
                            gridPanel.revalidate();
                            gridPanel.repaint();
                        }
                    });


                    gridPanel.add(empPanel);
                }
            }
            gridPanel.revalidate();
            gridPanel.repaint();
        };

        btnSearch.addActionListener(e -> updateGrid.run());
        updateGrid.run();

        return mainPanel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmpDashboardAdminView().setVisible(true);
        });
    }

	public void setSearchAction(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

	public String getSearchText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateTable(List<Employee> employees) {
		// TODO Auto-generated method stub
		
	}
}
