package org.ictkerala.javatraning;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentSignupGUI extends JFrame {
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dobField;
    private JTextField genderField;
    private JTextField emailField;
    private JTextField semesterField;
    private JTextField subjectField;
    private JTextField departmentField;
    private JPasswordField passwordField;

    public StudentSignupGUI() {
        setTitle("Student Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(630, 480);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(182, 214, 228));
        panel.setLayout(null);

        JLabel label = new JLabel("RollNumber:");
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label.setBounds(10, 11, 201, 30);
        panel.add(label);
        idField = new JTextField();
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        idField.setBounds(238, 11, 326, 30);
        panel.add(idField);

        JLabel label_1 = new JLabel("First Name:");
        label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label_1.setBounds(10, 52, 121, 29);
        panel.add(label_1);
        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        firstNameField.setBounds(238, 52, 326, 29);
        panel.add(firstNameField);

        JLabel label_2 = new JLabel("Last Name:");
        label_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label_2.setBounds(10, 94, 156, 29);
        panel.add(label_2);
        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lastNameField.setBounds(238, 92, 326, 29);
        panel.add(lastNameField);

        JLabel label_3 = new JLabel("Date of Birth (YYYY-MM-DD):");
        label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label_3.setBounds(10, 134, 234, 29);
        panel.add(label_3);
        dobField = new JTextField();
        dobField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        dobField.setBounds(238, 132, 326, 29);
        panel.add(dobField);

        JLabel label_4 = new JLabel("Gender:");
        label_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label_4.setBounds(10, 168, 218, 40);
        panel.add(label_4);
        genderField = new JTextField();
        genderField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        genderField.setBounds(238, 214, 326, 29);
        panel.add(genderField);

        JLabel label_5 = new JLabel("Email:");
        label_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label_5.setBounds(10, 212, 146, 29);
        panel.add(label_5);
        emailField = new JTextField();
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        emailField.setBounds(238, 174, 326, 29);
        panel.add(emailField);

        JLabel label_6 = new JLabel("Semester:");
        label_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label_6.setBounds(10, 244, 187, 40);
        panel.add(label_6);
        semesterField = new JTextField();
        semesterField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        semesterField.setBounds(238, 250, 326, 29);
        panel.add(semesterField);

        JLabel label_7 = new JLabel("Password:");
        label_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label_7.setBounds(10, 284, 201, 40);
        panel.add(label_7);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passwordField.setBounds(238, 290, 326, 29);
        panel.add(passwordField);
        

       JLabel label_8 = new JLabel("Subject:");
       label_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
       label_8.setBounds(10, 324, 201, 30);
       panel.add(label_8);
       subjectField = new JTextField();
       subjectField.setFont(new Font("Tahoma", Font.PLAIN, 12));
       subjectField.setBounds(238, 324, 326, 30);
       panel.add(subjectField);

       // Department
       JLabel label_9 = new JLabel("Department:");
       label_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
       label_9.setBounds(10, 364, 201, 30);
       panel.add(label_9);
       departmentField = new JTextField();
       departmentField.setFont(new Font("Tahoma", Font.PLAIN, 12));
       departmentField.setBounds(238, 364, 326, 30);
       panel.add(departmentField);


        JButton signUpButton = new JButton("Register");
        signUpButton.setBackground(new Color(255, 255, 255));
        signUpButton.setFont(new Font("Cambria Math", Font.BOLD, 13));
        signUpButton.setBounds(342, 405, 100, 29);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });
        panel.add(signUpButton);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(255, 255, 255));
        backButton.setFont(new Font("Cambria Math", Font.BOLD, 13));
        backButton.setBounds(464, 405, 100, 29);
     // Modify the ActionListener for the Back button in the StudentSignupGUI class
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current student signup GUI
                setVisible(false);

                // Show the previous student login GUI
                studentLoginGUI.setVisible(true);

                // Clear any entered data in the signup fields
                idField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                dobField.setText("");
                genderField.setText("");
                emailField.setText("");
                semesterField.setText("");
                passwordField.setText("");
                subjectField.setText("");
                departmentField.setText("");

                // Dispose of the current student signup GUI
                dispose();
            }
        });

        panel.add(backButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Cambria Math", Font.BOLD, 13));
        cancelButton.setBounds(238, 405, 94, 29);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelSignUp();
            }
        });
        panel.add(cancelButton);

        getContentPane().add(panel);
        setVisible(true);
    }

    public StudentSignupGUI(StudentLoginGUI studentLoginGUI) {
		// TODO Auto-generated constructor stub
	}

    private void signUp() {
        String id = idField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dob = dobField.getText();
        String gender = genderField.getText();
        String email = emailField.getText();
        String address = semesterField.getText();
        String password = new String(passwordField.getPassword());
        String subject = subjectField.getText();
        String department = departmentField.getText();

        // Perform validation if needed

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examhall", "root", "Sreyas@2002");
            String query = "INSERT INTO Students (RollNumber, FirstName, LastName, DateOfBirth, Gender, Email, Semester, Password, Subject, Department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setDate(4, Date.valueOf(dob));
            statement.setString(5, gender);
            statement.setString(6, email);
            statement.setString(7, address);
            statement.setString(8, password);
            statement.setString(9, subject);
            statement.setString(10, department);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Student Registration successful.");
                // Reset fields after successful sign-up
                idField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                dobField.setText("");
                genderField.setText("");
                emailField.setText("");
                semesterField.setText("");
                passwordField.setText("");
                subjectField.setText("");
                departmentField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Registration student.");
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred.");
        }
    }


    private void goBack() {
        dispose(); // Close the current window
    }
 // Close the current window
	private StudentLoginGUI studentLoginGUI;

	public void StudentSignupGUI1(StudentLoginGUI studentLoginGUI) {
	    this.studentLoginGUI = studentLoginGUI;
	    // Rest of your constructor code
	}

    private void cancelSignUp() {
        dispose(); // Close the window and cancel the sign-up process
    }
    private void signupComplete() {
        // Perform signup logic and database operations
        
        // Show a dialog or message to indicate signup completion
        
        StudentLoginGUI studentLoginGUI = new StudentLoginGUI();
		// Return to the student login GUI
        studentLoginGUI.returnFromSignup();
        dispose(); // Close the student signup GUI
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentSignupGUI();
            }
        });
    }
}
