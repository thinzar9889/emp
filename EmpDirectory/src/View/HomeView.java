package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class HomeView extends JFrame {
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private Map<String, JPanel> panels = new LinkedHashMap<>();
    private Map<String, JLabel> navLabels = new LinkedHashMap<>();
    private Color normalColor = Color.BLACK;
    private Color hoverColor = new Color(0, 0, 255);
    private Color activeColor = new Color(34, 139, 34);
    private JLabel activeLabel = null;

    public HomeView() {
        setTitle("Employee Directory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
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

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        leftPanel.setOpaque(false);

        JLabel menuIcon = new JLabel("\u2630");
        menuIcon.setFont(new Font("Arial", Font.PLAIN, 20));
        menuIcon.setForeground(Color.WHITE);

        JLabel systemName = new JLabel("Employee Directory");
        systemName.setFont(new Font("Arial", Font.PLAIN, 14));
        systemName.setForeground(Color.BLACK);

        leftPanel.add(menuIcon);
        leftPanel.add(systemName);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        navPanel.setOpaque(false);

        String[] menuItems = { "Employee Dashboard", "Admin Dashboard", "Add Admin" };

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
            @Override
            public void mouseEntered(MouseEvent e) {
                logoutButton.setBackground(new Color(200, 35, 50));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoutButton.setBackground(new Color(220, 53, 69));
            }
        });

        logoutButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
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
        label.setOpaque(false);
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (label != activeLabel) {
                    label.setForeground(hoverColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (label != activeLabel) {
                    label.setForeground(normalColor);
                }
            }

            @Override
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
        panels.put("AddAdmin", new AdminPanel());
        panels.put("AdminDashboard", panelWithLabel("Admin Dashboard"));
        panels.put("EmployeeDashboard", new EmpDashboardAdminPanel());
    }

    private JPanel panelWithLabel(String text) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(text));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeView view = new HomeView();
            view.setVisible(true);
        });
    }
}
