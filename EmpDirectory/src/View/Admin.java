package View;

import javax.swing.*;

public class Admin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
    public Admin() {

        JButton detailButton = new JButton("Go to Employee Detail");
        detailButton.setBounds(378, 33, 150, 23);
        detailButton.addActionListener(e -> {
            new EmployeeDetailPage().setVisible(true); // opens another JFrame
        });
        setLayout(null);

        add(detailButton);
        
        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(67, 106, 69, 14);
        add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(40, 131, 306, 20);
        add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Phone");
        lblNewLabel_1.setBounds(67, 172, 49, 14);
        add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(40, 193, 306, 20);
        add(textField_1);
        textField_1.setColumns(10);
    }
}
