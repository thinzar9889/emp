package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpDashboardAdminView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private CardLayout cardLayout;
	private Map<String, JPanel> panels = new LinkedHashMap<>();
	private Map<String, JLabel> navLabels = new LinkedHashMap<>();
	private Color normalColor = Color.black;
	private Color hoverColor = new Color(0, 0, 255); // Blue
	private Color activeColor = new Color(34, 139, 34); // Forest Green

	private JLabel activeLabel = null;
	private JTextField textField;

	public EmpDashboardAdminView() {
		setTitle("Employee Directory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
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

		cardLayout.show(contentPanel, "AdminDashboard");
		setActiveNav("Admin Dashboard");

		mainPanel.add(contentPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.add(panel, "name_3002885783000");
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(51, 84, 456, 32);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(534, 83, 85, 32);
		panel.add(btnNewButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.RED);
		btnAdd.setBounds(639, 83, 66, 32);
		panel.add(btnAdd);

		
		getContentPane().add(mainPanel);
	}

	

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			EmpDashboardAdminView view = new EmpDashboardAdminView();
			view.setVisible(true);
		});
	}
}
