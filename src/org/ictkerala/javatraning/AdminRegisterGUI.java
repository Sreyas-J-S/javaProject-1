package org.ictkerala.javatraning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminRegisterGUI extends JFrame {
    private JTextField adminIdField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JLabel messageLabel;
    private AdminLoginGUI adminLoginGUI;

    public AdminRegisterGUI(AdminLoginGUI adminLoginGUI) {
        this.adminLoginGUI = adminLoginGUI;
        setTitle("Admin Registration");
        setSize(600, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(155, 205, 255));
        mainPanel.setLayout(null);

        JPanel registerPanel = new JPanel();
        registerPanel.setBounds(134, 0, 324, 457);
        registerPanel.setBackground(new Color(47, 151, 255));

        JLabel adminIdLabel = new JLabel("ADMIN ID:");
        adminIdLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        adminIdLabel.setForeground(new Color(255, 255, 255));
        adminIdField = new JTextField();
        JLabel usernameLabel = new JLabel("USERNAME:");
        usernameLabel.setForeground(new Color(255, 255, 255));
        usernameLabel.setBackground(new Color(255, 255, 255));
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("PASSWORD*:");
        passwordLabel.setForeground(new Color(255, 255, 255));
        passwordLabel.setBackground(new Color(255, 255, 255));
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        passwordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel("CONFIRM PASSWORD*:");
        confirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        confirmPasswordLabel.setBackground(new Color(255, 255, 255));
        confirmPasswordLabel.setForeground(new Color(255, 255, 255));
        confirmPasswordField = new JPasswordField();
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        registerButton.setForeground(new Color(255, 255, 255));
        registerButton.setBackground(new Color(0, 128, 192));
        messageLabel = new JLabel();

        mainPanel.add(registerPanel);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(0, 64, 128));
        
        JLabel lblNewLabel = new JLabel("REGISTRATION");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 30));

        GroupLayout gl_registerPanel = new GroupLayout(registerPanel);
        gl_registerPanel.setHorizontalGroup(
        	gl_registerPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(confirmPasswordLabel)
        			.addContainerGap(167, Short.MAX_VALUE))
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(confirmPasswordField, 284, 284, 284)
        			.addContainerGap(30, Short.MAX_VALUE))
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(215, Short.MAX_VALUE))
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(adminIdField, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        			.addGap(30))
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(adminIdLabel)
        			.addContainerGap(250, Short.MAX_VALUE))
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addGap(21)
        			.addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
        			.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        			.addGap(37))
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addContainerGap(91, Short.MAX_VALUE)
        			.addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        			.addGap(45))
        		.addGroup(Alignment.LEADING, gl_registerPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addGroup(Alignment.LEADING, gl_registerPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_registerPanel.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(passwordField, Alignment.LEADING)
        				.addComponent(usernameField, Alignment.LEADING, 284, 284, Short.MAX_VALUE))
        			.addContainerGap(30, Short.MAX_VALUE))
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addContainerGap(55, Short.MAX_VALUE)
        			.addComponent(lblNewLabel)
        			.addGap(53))
        );
        gl_registerPanel.setVerticalGroup(
        	gl_registerPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_registerPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(7)
        			.addComponent(adminIdLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(adminIdField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(usernameLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(passwordLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addGap(11)
        			.addComponent(confirmPasswordLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(23)
        			.addGroup(gl_registerPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(registerButton)
        				.addComponent(backButton))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(35, Short.MAX_VALUE))
        );
        registerPanel.setLayout(gl_registerPanel);
        mainPanel.add(registerPanel);

        getContentPane().add(mainPanel);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAdmin();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBackToLogin();
            }
        });
    }

    private void registerAdmin() {
        String adminId = adminIdField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (adminId.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showMessage("Please fill in all the fields.");
        } else if (!password.equals(confirmPassword)) {
            showMessage("Passwords do not match.");
        } else if (!validateAdminID(adminId)) {
            showMessage("Admin ID is wrong.");
        } else {
            if (insertAdminData(username, password)) {
                showMessage("Registration successful!");
                goBackToLogin();
            } else {
                showMessage("Registration failed. Invalid Admin ID.");
            }
        }
    }

    private boolean validateAdminID(String adminId) {
        // Modify the database URL, username, and password according to your database configuration
        String DB_URL = "jdbc:mysql://localhost:3306/examhall";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "Sreyas@2002";

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare the SQL statement to check if the admin ID exists
            String sql = "SELECT * FROM AdminID WHERE AdminID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, adminId);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the admin ID exists
            boolean exists = resultSet.next();

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();

            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private boolean insertAdminData(String username, String password) {
        // Modify the database URL, username, and password according to your database configuration
        String DB_URL = "jdbc:mysql://localhost:3306/examhall";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "Sreyas@2002";

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare the SQL statement to insert the admin data
            String sql = "INSERT INTO Admin ( username, password) VALUES ( ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the query
            int rowsInserted = statement.executeUpdate();

            // Close the resources
            statement.close();
            connection.close();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void goBackToLogin() {
        adminLoginGUI.setVisible(true);
        dispose();
    }

    private void showMessage(String message) {
        messageLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AdminRegisterGUI adminRegisterGUI = new AdminRegisterGUI(null);
                adminRegisterGUI.setVisible(true);
            }
        });
    }
}
