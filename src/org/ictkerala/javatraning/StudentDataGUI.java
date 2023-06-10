package org.ictkerala.javatraning;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentDataGUI extends JFrame {
    private static JTextField firstNameField;
    private static JTextField lastNameField;
    private static JTextField dobField;
    private static JTextField genderField;
    private static JTextField emailField;
    private static JTextField semesterField;
    private static JTextField subjectField;
    private static JTextField departmentField;
    private static JTextField seatNumberField;
    private static JTextField classField; // New field for Class attribute

    public StudentDataGUI(String rollNumber) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Data");
        setSize(635, 475);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        firstNameLabel.setBounds(38, 1, 200, 28);
        firstNameField = new JTextField();
        firstNameField.setBounds(307, 2, 297, 28);
        firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.setLayout(null);
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lastNameLabel.setBounds(38, 40, 200, 28);
        lastNameField = new JTextField();
        lastNameField.setBounds(307, 40, 297, 28);
        lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(lastNameLabel);
        panel.add(lastNameField);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        dobLabel.setBounds(38, 79, 200, 28);
        dobField = new JTextField();
        dobField.setBounds(307, 78, 297, 28);
        dobField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(dobLabel);
        panel.add(dobField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        genderLabel.setBounds(38, 118, 200, 28);
        genderField = new JTextField();
        genderField.setBounds(307, 116, 297, 28);
        genderField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(genderLabel);
        panel.add(genderField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailLabel.setBounds(38, 157, 200, 28);
        emailField = new JTextField();
        emailField.setBounds(307, 154, 297, 28);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel semesterLabel = new JLabel("Semester:");
        semesterLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        semesterLabel.setBounds(38, 196, 200, 28);
        semesterField = new JTextField();
        semesterField.setBounds(307, 192, 297, 28);
        semesterField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(semesterLabel);
        panel.add(semesterField);

        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        subjectLabel.setBounds(38, 231, 200, 28);
        subjectField = new JTextField();
        subjectField.setBounds(307, 230, 297, 28);
        subjectField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(subjectLabel);
        panel.add(subjectField);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        departmentLabel.setBounds(38, 270, 200, 28);
        departmentField = new JTextField();
        departmentField.setBounds(307, 268, 297, 28);
        departmentField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(departmentLabel);
        panel.add(departmentField);
        
        JLabel seatNumberLabel = new JLabel("Seat Number:");
        seatNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        seatNumberLabel.setBounds(38, 307, 194, 28);
        seatNumberField = new JTextField();
        seatNumberField.setBounds(307, 306, 297, 28);
        seatNumberField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        seatNumberField.setEditable(false); // Set the field as read-only
        panel.add(seatNumberLabel);
        panel.add(seatNumberField);

        JLabel classLabel = new JLabel("Class:"); // New label for Class attribute
        classLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        classLabel.setBounds(38, 346, 200, 28);
        classField = new JTextField();
        classField.setBounds(307, 346, 297, 28);
        classField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        classField.setEditable(false); // Set the field as read-only
        panel.add(classLabel);
        panel.add(classField);
        // Create an update button
        
        
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(349, 382, 194, 28);
        updateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String updatedFirstName = firstNameField.getText();
                String updatedLastName = lastNameField.getText();
                String updatedDOB = dobField.getText();
                String updatedGender = genderField.getText();
                String updatedEmail = emailField.getText();
                String updatedSemester = semesterField.getText();
                String updatedSubject = subjectField.getText();
                String updatedDepartment = departmentField.getText();

                updateStudentData(rollNumber, updatedFirstName, updatedLastName, updatedDOB,
                        updatedGender, updatedEmail, updatedSemester, updatedSubject, updatedDepartment);
            }
        });

       
        JButton backButton = new JButton("Close");
        backButton.setBounds(38, 382, 200, 28);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current StudentDataGUI instance
 
            }
        });


        JLabel label = new JLabel();
        label.setBounds(0, 344, 297, 28);
        panel.add(label);
        panel.add(updateButton);
        JLabel label_1 = new JLabel();
        label_1.setBounds(27, 382, 236, 28);
        panel.add(label_1);
        panel.add(backButton);

        getContentPane().add(panel);
        fetchStudentData(rollNumber);
    }

    private void fetchStudentData(String rollNumber) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/examhall";
            String dbUsername = "root";
            String dbPassword = "Sreyas@2002";
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Prepare and execute the query
            String query = "SELECT * FROM Students WHERE RollNumber = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, rollNumber);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String dob = resultSet.getString("DateOfBirth");
                String gender = resultSet.getString("Gender");
                String email = resultSet.getString("Email");
                String semester = resultSet.getString("Semester");
                String subject = resultSet.getString("Subject");
                String department = resultSet.getString("Department");
                String classValue = resultSet.getString("Class");
                String seatNumber = resultSet.getString("SeatNumber");

                // Display the fetched data in the text fields
                firstNameField.setText(firstName);
                lastNameField.setText(lastName);
                dobField.setText(dob);
                genderField.setText(gender);
                emailField.setText(email);
                semesterField.setText(semester);
                subjectField.setText(subject);
                departmentField.setText(department);
                classField.setText(classValue);
                seatNumberField.setText(seatNumber);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateStudentData(String rollNumber, String updatedFirstName, String updatedLastName,
                                   String updatedDOB, String updatedGender, String updatedEmail,
                                   String updatedSemester, String updatedSubject, String updatedDepartment) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/examhall";
            String dbUsername = "root";
            String dbPassword = "Sreyas@2002";
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Prepare and execute the update statement
            String query = "UPDATE Students SET FirstName = ?, LastName = ?, DateOfBirth = ?, " +
                    "Gender = ?, Email = ?, Semester = ?, Subject = ?, Department = ? WHERE RollNumber = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, updatedFirstName);
            statement.setString(2, updatedLastName);
            statement.setString(3, updatedDOB);
            statement.setString(4, updatedGender);
            statement.setString(5, updatedEmail);
            statement.setString(6, updatedSemester);
            statement.setString(7, updatedSubject);
            statement.setString(8, updatedDepartment);
            statement.setString(9, rollNumber);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data updated successfully!");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String rollNumber = "your-roll-number";
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentDataGUI(rollNumber).setVisible(true);
            }
        });
    }
}
