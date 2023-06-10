package org.ictkerala.javatraning;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginGUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;
    private JButton registerButton;
    private JLabel messageLabel;
    private MenuGUI menuGUI;
    private JPanel panel;
    private JLabel lblNewLabel;

    public AdminLoginGUI(MenuGUI menuGUI) {
        setTitle("Admin Login");
        setSize(600, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel mainPanel = new JPanel();

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(128, 128, 128));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password*:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(0, 128, 192));
        messageLabel = new JLabel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        mainPanel.add(loginPanel);

        panel = new JPanel();
        panel.setBackground(new Color(128, 128, 128));
        backButton = new JButton("Back");
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setBackground(new Color(0, 64, 128));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to the menu GUI
                if (menuGUI != null) {
                    menuGUI.setVisible(true);
                }
                dispose(); // Close the admin login GUI
            }
        });
        registerButton = new JButton("Register");
        registerButton.setForeground(new Color(255, 255, 255));
        registerButton.setBackground(new Color(225, 225, 0));

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAdminRegisterGUI();
            }
        });

        GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
        gl_loginPanel.setHorizontalGroup(
                gl_loginPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_loginPanel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_loginPanel.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passwordField)
                                                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
                                        .addGroup(gl_loginPanel.createSequentialGroup()
                                                .addGap(37)
                                                .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(backButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                                        .addComponent(registerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(44))
        );
        gl_loginPanel.setVerticalGroup(
                gl_loginPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_loginPanel.createSequentialGroup()
                                .addGap(44)
                                .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_loginPanel.createSequentialGroup()
                                                .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                .addGap(47)
                                                .addComponent(passwordLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                .addGap(31)
                                                .addComponent(loginButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(registerButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(backButton))
                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(new Color(192, 192, 192));
        lblNewLabel.setIcon(new ImageIcon(AdminLoginGUI.class.getResource("/IMAGES/undraw_programming_2svr@2x.png")));
        panel.add(lblNewLabel);
        loginPanel.setLayout(gl_loginPanel);
        mainPanel.add(messageLabel);

        getContentPane().add(mainPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Call the login validation method for admin
                boolean isAdmin = validateAdminLogin(username, password);

                if (isAdmin) {
                    // Admin login successful
                    openAdminPortal();
                } else {
                    // Login failed, display error message
                    JOptionPane.showMessageDialog(AdminLoginGUI.this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public AdminLoginGUI() {
		// TODO Auto-generated constructor stub
	}

	private boolean validateAdminLogin(String username, String password) {
        // Modify the database URL, username, and password according to your database configuration
        String url = "jdbc:mysql://127.0.0.1:3306/examhall";
        String dbUsername = "root";
        String dbPassword = "Sreyas@2002";

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/examhall", "root", "Sreyas@2002");

            // Prepare the SQL statement to retrieve the admin credentials
            String sql = "SELECT * FROM Admin WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the query returned any rows
            boolean isValid = resultSet.next();

            // Close the database resources
            resultSet.close();
            statement.close();
            connection.close();

            return isValid;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void openAdminPortal() {
        AdminGUI adminPortalGUI = new AdminGUI(this);
        adminPortalGUI.setVisible(true);
        dispose(); // Close the admin login GUI
    }

    private void openAdminRegisterGUI() {
        AdminRegisterGUI adminRegisterGUI = new AdminRegisterGUI(this);
        adminRegisterGUI.setVisible(true);
        this.setVisible(false); // Hide the admin login GUI
    }
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    AdminLoginGUI adminLoginGUI = new AdminLoginGUI(null);
                    adminLoginGUI.setVisible(true);
                }
            });
    }
}

