package org.ictkerala.javatraning;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MenuGUI extends JFrame {
    private JButton adminButton;
    private JButton studentButton;
    private JPanel panel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel;

    public MenuGUI() {
        setTitle("Login Menu");
        setSize(651, 482);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JPanel mainPanel = new JPanel();
        mainPanel.setForeground(new Color(255, 255, 255));
        mainPanel.setBackground(new Color(45, 80, 94));

        adminButton = new JButton("ADMIN LOGIN");
        adminButton.setBounds(66, 216, 175, 39);
        adminButton.setFont(new Font("Courier New", Font.BOLD, 16));
        adminButton.setBackground(new Color(255, 255, 255));
        adminButton.setForeground(new Color(0, 0, 0));
        studentButton = new JButton("STUDENT LOGIN");
        studentButton.setBounds(66, 296, 175, 39);
        studentButton.setFont(new Font("Courier New", Font.BOLD, 16));
        studentButton.setForeground(new Color(0, 0, 0));
        studentButton.setBackground(new Color(255, 255, 255));

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        panel = new JPanel();
        panel.setBounds(295, 0, 348, 472);
        panel.setBackground(new Color(174, 174, 255));
        
        lblNewLabel_1 = new JLabel("WELCOME");
        lblNewLabel_1.setBounds(44, 64, 220, 104);
        lblNewLabel_1.setBackground(new Color(0, 0, 0));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Ink Free", Font.BOLD, 46));
        
        lblNewLabel_2 = new JLabel("Choose your usertype:");
        lblNewLabel_2.setBounds(65, 162, 220, 55);
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        
        lblNewLabel_3 = new JLabel("OR");
        lblNewLabel_3.setBounds(137, 252, 23, 55);
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.setLayout(null);
        mainPanel.setLayout(null);
        mainPanel.add(lblNewLabel_1);
        mainPanel.add(lblNewLabel_2);
        mainPanel.add(adminButton);
        mainPanel.add(studentButton);
        mainPanel.add(lblNewLabel_3);
        mainPanel.add(panel);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel.setIcon(new ImageIcon(MenuGUI.class.getResource("/IMAGES/Diversity-and-hiring-for-culture-fit.png")));
        lblNewLabel.setBounds(-154, -211, 1400, 756);
        panel.add(lblNewLabel);
        
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBounds(10, 0, 349, 472);
        panel.add(horizontalBox);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAdminLogin();
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStudentLogin();
            }
        });
    }

    private void openAdminLogin() {
        AdminLoginGUI adminLogin = new AdminLoginGUI(this);
        adminLogin.setVisible(true);
        setVisible(false); 
    }

    private void openStudentLogin() {
        StudentLoginGUI studentLogin = new StudentLoginGUI(this);
        studentLogin.setVisible(true);
        setVisible(false); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuGUI menuGUI = new MenuGUI();
                menuGUI.setVisible(true);
            }
        });
    }
}
