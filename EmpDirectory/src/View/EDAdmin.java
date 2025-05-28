package View;

import javax.swing.*;
import java.awt.*;

public class EDAdmin extends JPanel {

    private static final long serialVersionUID = 1L;
    private static JTextField txtLastName;
    private static JTextField txtPhoneNumber;
    private static JTextField txtEmail;
    private static JTextField txtHiringDate;
    private static JTextField txtDepartment;
    private static JTextField txtJobTitle;

    public EDAdmin() {
        setLayout(null);

        JLabel lblHeader = new JLabel("Employee Details");
        lblHeader.setBounds(40, 20, 300, 30);
        lblHeader.setFont(new Font("MS UI Gothic", Font.BOLD, 24));
        add(lblHeader);

        setPreferredSize(new Dimension(1000, 753));
        setBackground(new Color(245, 245, 245));
        
        JPanel panel = new JPanel();
        panel.setBounds(56, 89, 419, 596);
        add(panel);
                panel.setLayout(null);
        
                JLabel lblName = new JLabel("Name");
                lblName.setBounds(10, 20, 54, 13);
                panel.add(lblName);
                
                        txtLastName = new JTextField();
                        txtLastName.setBounds(10, 46, 300, 25);
                        panel.add(txtLastName);
                        
                                JLabel lblEmail = new JLabel("Email");
                                lblEmail.setBounds(10, 87, 100, 20);
                                panel.add(lblEmail);
                                
                                        txtEmail = new JTextField();
                                        txtEmail.setBounds(10, 117, 300, 25);
                                        panel.add(txtEmail);
                                        
                                                JLabel lblPhone = new JLabel("Phone Number");
                                                lblPhone.setBounds(10, 152, 100, 20);
                                                panel.add(lblPhone);
                                                
                                                        txtPhoneNumber = new JTextField();
                                                        txtPhoneNumber.setBounds(10, 182, 300, 25);
                                                        panel.add(txtPhoneNumber);
                                                        
                                                                JLabel lblHiringDate = new JLabel("Hiring Date");
                                                                lblHiringDate.setBounds(10, 217, 100, 20);
                                                                panel.add(lblHiringDate);
                                                                
                                                                        txtHiringDate = new JTextField();
                                                                        txtHiringDate.setBounds(10, 249, 300, 25);
                                                                        panel.add(txtHiringDate);
                                                                        
                                                                                JLabel lblIsActive = new JLabel("Is Active");
                                                                                lblIsActive.setBounds(10, 287, 100, 20);
                                                                                panel.add(lblIsActive);
                                                                                
                                                                                        JCheckBox chkIsActive = new JCheckBox();
                                                                                        chkIsActive.setBounds(79, 282, 25, 25);
                                                                                        panel.add(chkIsActive);
                                                                                        chkIsActive.setBackground(Color.WHITE);
                                                                                        
                                                                                                JLabel lblIsAgreement = new JLabel("Is Agreement");
                                                                                                lblIsAgreement.setBounds(10, 317, 100, 20);
                                                                                                panel.add(lblIsAgreement);
                                                                                                
                                                                                                        JCheckBox chkIsAgreement = new JCheckBox();
                                                                                                        chkIsAgreement.setBounds(79, 313, 25, 25);
                                                                                                        panel.add(chkIsAgreement);
                                                                                                        chkIsAgreement.setBackground(Color.WHITE);
                                                                                                        
                                                                                                                JLabel lblIsManager = new JLabel("Is Manager");
                                                                                                                lblIsManager.setBounds(10, 347, 100, 20);
                                                                                                                panel.add(lblIsManager);
                                                                                                                
                                                                                                                        JCheckBox chkIsManager = new JCheckBox();
                                                                                                                        chkIsManager.setBounds(79, 342, 25, 25);
                                                                                                                        panel.add(chkIsManager);
                                                                                                                        chkIsManager.setBackground(Color.WHITE);
                                                                                                                        
                                                                                                                                JLabel lblDepartment = new JLabel("Department");
                                                                                                                                lblDepartment.setBounds(10, 377, 100, 20);
                                                                                                                                panel.add(lblDepartment);
                                                                                                                                
                                                                                                                                        txtDepartment = new JTextField();
                                                                                                                                        txtDepartment.setBounds(10, 408, 300, 25);
                                                                                                                                        panel.add(txtDepartment);
                                                                                                                                        
                                                                                                                                                JLabel lblJobTitle = new JLabel("Job Title");
                                                                                                                                                lblJobTitle.setBounds(10, 456, 100, 20);
                                                                                                                                                panel.add(lblJobTitle);
                                                                                                                                                
                                                                                                                                                        txtJobTitle = new JTextField();
                                                                                                                                                        txtJobTitle.setBounds(10, 491, 300, 25);
                                                                                                                                                        panel.add(txtJobTitle);
                                                                                                                                                        
                                                                                                                                                                JButton btnSave = new JButton("Save");
                                                                                                                                                                btnSave.setBounds(61, 540, 100, 30);
                                                                                                                                                                panel.add(btnSave);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("EDAdmin");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new JScrollPane(new EDAdmin()));
            frame.setSize(1000, 750);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
