package View;

import javax.swing.*;
import java.awt.*;

public class EmpDashboardAdminPanel extends JPanel {
    private JTextField textField;

    public EmpDashboardAdminPanel() {
        setBackground(SystemColor.inactiveCaptionBorder);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Employee Dashboard");
        lblNewLabel.setFont(new Font("Pyidaungsu", Font.PLAIN, 25));
        lblNewLabel.setBounds(103, 39, 329, 29);
        add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(103, 97, 413, 37);
        add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Search");
        btnNewButton.setBackground(new Color(255, 0, 0));
        btnNewButton.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
        btnNewButton.setBounds(526, 97, 85, 37);
        add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Add");
        btnNewButton_1.setBackground(new Color(255, 0, 0));
        btnNewButton_1.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
        btnNewButton_1.setBounds(632, 97, 85, 37);
        add(btnNewButton_1);
    }
}
