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


public class StudentLoginGUI extends JFrame {
    private boolean validateStudentLogin1(String RollNumber, String Password) {
        String url = "jdbc:mysql://127.0.0.1:3306/examhall"; // Modify the database URL
        String dbUsername = "root"; // Modify the database username
        String dbPassword = "Sreyas@2002"; // Modify the database password

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/examhall", "root", "Sreyas@2002");

            String sql = "SELECT * FROM Students WHERE RollNumber = ? AND Password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, RollNumber);
            statement.setString(2, Password);

            ResultSet resultSet = statement.executeQuery();

            boolean isValid = resultSet.next();

            resultSet.close();
            statement.close();
            connection.close();

            return isValid;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    private JTextField rollNumberField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;
    private JLabel messageLabel;
    private MenuGUI menuGUI;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    private JLabel lblNewLabel_1;

    public StudentLoginGUI(MenuGUI menuGUI) {
    	this.menuGUI = menuGUI;
        setTitle("Student Login");
        setSize(630, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(255, 255, 255));
        messageLabel = new JLabel();
                
                        JLabel usernameLabel = new JLabel("RollNumber:");
                        rollNumberField = new JTextField();
                JLabel passwordLabel = new JLabel("Password*:");
                passwordField = new JPasswordField();
                loginButton = new JButton("Login");
                loginButton.setBackground(new Color(128, 0, 255));
                loginButton.setForeground(new Color(255, 255, 255));
                
                        loginButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String RollNumber = rollNumberField.getText();
                                String Password = new String(passwordField.getPassword());
                
                                // Call the login validation method for student
                                boolean isStudent = validateStudentLogin1(RollNumber, Password);
                
                                if (isStudent) {
                                    // Student login successful
                                    openStudentPortal();
                                } else {
                                    // Login failed, display error message
                                    messageLabel.setText("Invalid RollNumber or Password.");
                                }
                            }
                        });

        mainPanel.add(loginPanel, BorderLayout.CENTER);
        backButton = new JButton("Back");
        backButton.setBackground(new Color(64, 0, 128));
        backButton.setForeground(new Color(255, 255, 255));
        
       

        // Add an action listener to the Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current student login GUI
                setVisible(false);

                // Show the menu GUI
                menuGUI.setVisible(true);

                // Clear the username and password fields
                rollNumberField.setText("");
                passwordField.setText("");

                // Clear any error message
                messageLabel.setText("");

                // Dispose of the current student login GUI
                dispose();
            }
        });

        panel = new JPanel();
        
        btnNewButton = new JButton("Register");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setForeground(new Color(0, 128, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the student signup GUI only if menuGUI is not null
                if (menuGUI != null) {
                    StudentSignupGUI signupGUI = new StudentSignupGUI();
                    signupGUI.setVisible(true);
                } else {
                    // Perform signup logic and database operations here

                    // Show a dialog or message to indicate signup completion

                    // Return to the student login GUI
                    returnFromSignup();
                }
            }
        });


        
        lblNewLabel_1 = new JLabel("Don't have an account?");
        GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
        gl_loginPanel.setHorizontalGroup(
        	gl_loginPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_loginPanel.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
        			.addGroup(gl_loginPanel.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_loginPanel.createSequentialGroup()
        					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        						.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_loginPanel.createSequentialGroup()
        							.addGap(54)
        							.addGroup(gl_loginPanel.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(backButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(loginButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
        						.addGroup(gl_loginPanel.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(passwordField, Alignment.LEADING)
        							.addComponent(rollNumberField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
        					.addGap(37))
        				.addGroup(gl_loginPanel.createSequentialGroup()
        					.addComponent(lblNewLabel_1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
        					.addGap(27))))
        );
        gl_loginPanel.setVerticalGroup(
        	gl_loginPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_loginPanel.createSequentialGroup()
        			.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_loginPanel.createSequentialGroup()
        					.addGap(22)
        					.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(rollNumberField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        					.addGap(25)
        					.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(loginButton)
        					.addGap(18)
        					.addComponent(backButton)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1)
        						.addComponent(btnNewButton)))
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(50, Short.MAX_VALUE))
        );
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(StudentLoginGUI.class.getResource("/IMAGES/WhatsApp Image 2023-05-19 at 12.32.44.jpg")));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(36, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        loginPanel.setLayout(gl_loginPanel);
        mainPanel.add(messageLabel, BorderLayout.NORTH);

        getContentPane().add(mainPanel);
    }

    public StudentLoginGUI() {
		// TODO Auto-generated constructor stub
	}

	public StudentLoginGUI(AdminLoginGUI adminLoginGUI) {
		// TODO Auto-generated constructor stub
	}

	private boolean validateStudentLogin(String RollNumber, String Password) {
        // Implement your student login validation logic here
        // Compare the credentials against the student database or any other method of verification
        // Return true if the login is successful, false otherwise
        return false;
    }

    private void openStudentPortal() {
        // Get the entered RollNumber
        String rollNumber = rollNumberField.getText();

        // Create the student data GUI
        StudentDataGUI studentDataGUI = new StudentDataGUI(rollNumber);
        studentDataGUI.setVisible(true);

        // Close the student login GUI
        dispose();
    }
    public void returnFromSignup() {
        setVisible(true); // Make the student login GUI visible again
        rollNumberField.setText(""); // Clear the username field
        passwordField.setText(""); // Clear the password field
        messageLabel.setText(""); // Clear any error message
        
        System.out.println("Returned from signup"); // Add this line for debugging
    }
    public void returnFromLogin() {
        setVisible(true); // Make the student login GUI visible again
        rollNumberField.setText(""); // Clear the username field
        passwordField.setText(""); // Clear the password field
        messageLabel.setText(""); // Clear any error message
        
        System.out.println("Returned from signup"); // Add this line for debugging
    }
    
    
    public static void main(String[] args) {
        MenuGUI menuGUI = new MenuGUI();
        StudentLoginGUI studentLoginGUI = new StudentLoginGUI(menuGUI);
        studentLoginGUI.setVisible(true);
    }
}


