package View;
 
import javax.swing.*;

import java.awt.*;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.util.LinkedHashMap;

import java.util.Map;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class AddAdmin extends JFrame {
 
	private JPanel contentPanel;

	private CardLayout cardLayout;

	private Map<String, JPanel> panels = new LinkedHashMap<>();

	private Map<String, JLabel> navLabels = new LinkedHashMap<>();

	private Color normalColor = Color.BLACK;

	private Color hoverColor = new Color(0, 0, 255); // Blue

	private Color activeColor = new Color(34, 139, 34); // Forest Green
 
	private JLabel activeLabel = null;

	private static JTextField txtPhoneNumber;

	private static JTextField txtEmail;

	private static JTextField txtHiringDate;

	private static JTextField txtDepartment;

	private static JTextField txtJobTitle;

	private static JTextField txtName;
 
	public AddAdmin() {

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
 
		cardLayout.show(contentPanel, "AddAdmin");

		setActiveNav("Add Admin");
 
		mainPanel.add(contentPanel, BorderLayout.CENTER);


		getContentPane().add(mainPanel);

	}
 
	private JPanel createMenuBar() {

		JPanel menuBar = new JPanel(new BorderLayout());

		menuBar.setBackground(new Color(230, 230, 250));

		menuBar.setPreferredSize(new Dimension(getWidth(), 50));

		menuBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
 
		// Left: logo + system name

		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));

		leftPanel.setOpaque(false);
 
		JLabel menuIcon = new JLabel("\u2630");

		menuIcon.setFont(new Font("Arial", Font.PLAIN, 20));

		menuIcon.setForeground(Color.WHITE);
 
		JLabel systemName = new JLabel("Employee Directory");

		systemName.setFont(new Font("Arial", Font.PLAIN, 14));

		systemName.setForeground(new Color(0, 0, 0));
 
		leftPanel.add(menuIcon);

		leftPanel.add(systemName);
 
		// Center: navigation labels

		JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));

		navPanel.setOpaque(false);
 
		String[] menuItems = { "Employee Dashboard", "Admin Dashboard", "Add Admin" };
 
		for (String item : menuItems) {

			JLabel navLabel = createNavLabel(item);

			navLabels.put(item, navLabel);

			navPanel.add(navLabel);

		}
 
		// Right: logout button

		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));

		rightPanel.setOpaque(false);
 
		JButton logoutButton = new JButton("Logout");

		logoutButton.setFocusPainted(false);

		logoutButton.setForeground(Color.WHITE);

		logoutButton.setBackground(new Color(220, 53, 69)); // Bootstrap Danger color

		logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));

		logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		logoutButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
 
		// Button hover effect

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

				dispose(); // or redirect to login form

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

	    panels.put("AddAdmin", new Admin()); // <- Add this


		panels.put("AdminDashboard", panelWithLabel("Admin Dashboard"));

		panels.put("EmployeeDashboard", panelWithLabel("Employee Dashboard"));

	}
 
	private JPanel panelWithLabel(String text) {

		JPanel panel = new JPanel();

		panel.add(new JLabel(text));

		return panel;

	}
 
	
//	static JPanel createAddAdmin() {

//	    JPanel panel = new JPanel();
//
//	    panel.setBackground(new Color(255, 255, 255));
//
//	    panel.setLayout(new BorderLayout()); // Use BorderLayout to fill the entire panel
// 
//	    // Create a panel to hold the form content
//
//	    JPanel panel_1 = new JPanel();
//
//	    panel_1.setLayout(null); // Still using null layout for absolute positioning
//
//	    panel_1.setPreferredSize(new Dimension(635, 1000)); // Make sure it's large enough to accommodate all components
// 
//	    // Add the form components to panel_1
//
//	    JLabel lblNewLabel_1 = new JLabel("Name");
//
//	    lblNewLabel_1.setBounds(54, 32, 79, 19);
//
//	    panel_1.add(lblNewLabel_1);
// 
//	    txtName = new JTextField();
//
//	    txtName.setBounds(54, 61, 580, 26);
//
//	    panel_1.add(txtName);
//
//	    txtName.setColumns(10);
// 
//	    JLabel lblNewLabel_2 = new JLabel("Phone Number");
//
//	    lblNewLabel_2.setBounds(55, 108, 92, 19);
//
//	    panel_1.add(lblNewLabel_2);
// 
//	    txtPhoneNumber = new JTextField();
//
//	    txtPhoneNumber.setBounds(54, 137, 580, 26);
//
//	    panel_1.add(txtPhoneNumber);
//
//	    txtPhoneNumber.setColumns(10);
// 
//	    JLabel lblNewLabel_3 = new JLabel("Email");
//
//	    lblNewLabel_3.setBounds(55, 184, 92, 19);
//
//	    panel_1.add(lblNewLabel_3);
// 
//	    txtEmail = new JTextField();
//
//	    txtEmail.setBounds(54, 213, 580, 26);
//
//	    panel_1.add(txtEmail);
//
//	    txtEmail.setColumns(10);
// 
//	    JLabel lblNewLabel_4 = new JLabel("Hiring Date");
//
//	    lblNewLabel_4.setBounds(54, 249, 109, 19);
//
//	    panel_1.add(lblNewLabel_4);
// 
//	    txtHiringDate = new JTextField();
//
//	    txtHiringDate.setBounds(54, 278, 580, 26);
//
//	    panel_1.add(txtHiringDate);
//
//	    txtHiringDate.setColumns(10);
// 
//	    JLabel lblNewLabel_6 = new JLabel("Is Manager");
//
//	    lblNewLabel_6.setBounds(54, 314, 92, 19);
//
//	    panel_1.add(lblNewLabel_6);
// 
//	    JCheckBox chckbxIsManager = new JCheckBox("");
//
//	    chckbxIsManager.setBackground(new Color(255, 0, 0));
//
//	    chckbxIsManager.setBounds(54, 339, 103, 21);
//
//	    panel_1.add(chckbxIsManager);
// 
//	    JLabel lblNewLabel_5 = new JLabel("Is Active");
//
//	    lblNewLabel_5.setBounds(54, 386, 50, 19);
//
//	    panel_1.add(lblNewLabel_5);
// 
//	    JCheckBox chckbxIsActive = new JCheckBox("");
//
//	    chckbxIsActive.setBounds(55, 411, 120, 21);
//
//	    panel_1.add(chckbxIsActive);
// 
//	    JLabel lblNewLabel_7 = new JLabel("Is Agreement");
//
//	    lblNewLabel_7.setBounds(55, 444, 79, 19);
//
//	    panel_1.add(lblNewLabel_7);
// 
//	    JCheckBox chckbxIsAggrement = new JCheckBox("");
//
//	    chckbxIsAggrement.setBounds(55, 469, 103, 21);
//
//	    panel_1.add(chckbxIsAggrement);
// 
//	    JLabel lblNewLabel_8 = new JLabel("Department");
//
//	    lblNewLabel_8.setBounds(55, 496, 159, 19);
//
//	    panel_1.add(lblNewLabel_8);
// 
//	    txtDepartment = new JTextField();
//
//	    txtDepartment.setBounds(55, 525, 340, 26);
//
//	    panel_1.add(txtDepartment);
//
//	    txtDepartment.setColumns(10);
// 
//	    JLabel lblNewLabel_9 = new JLabel("Job Title");
//
//	    lblNewLabel_9.setBounds(55, 561, 109, 19);
//
//	    panel_1.add(lblNewLabel_9);
// 
//	    txtJobTitle = new JTextField();
//
//	    txtJobTitle.setBounds(55, 587, 340, 26);
//
//	    panel_1.add(txtJobTitle);
//
//	    txtJobTitle.setColumns(10);
// 
//	    JButton btnSave = new JButton("Save");
//
//	    btnSave.setBackground(new Color(255, 0, 0));
//
//	    btnSave.setBounds(56, 635, 91, 24);
//
//	    panel_1.add(btnSave);
// 
//	    JLabel lbAddAdmin = new JLabel("Add Admin Details");
//
//	    lbAddAdmin.setFont(new Font("Arial", Font.BOLD, 14));
//
//	    lbAddAdmin.setBounds(56, 27, 155, 36);
//
//	    panel_1.add(lbAddAdmin);
// 
//	    // Wrap the panel_1 inside a JScrollPane
//
//	    JScrollPane scrollPane = new JScrollPane(panel_1);
//
//	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//
//	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // You can set this to 'AS_NEEDED' if you want horizontal scrolling as well
// 
//	    // Add the scrollPane to the main panel
//
//	    panel.add(scrollPane, BorderLayout.CENTER);
// 
//	    return panel;

//	}
 
 
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			AddAdmin view = new AddAdmin();

			view.setVisible(true);

		});

	}

}
 