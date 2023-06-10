package org.ictkerala.javatraning;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminGUI extends JFrame {
    private JTextField rollNumberField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dobField;
    private JTextField genderField;
    private JTextField departmentField;
    private JTextField semesterField;
    private JTextField subjectField;
    private JTextField passwordField;
    private JTable studentsTable;
    private DefaultTableModel tableModel;
    private JButton seatingButton;
    private JButton backButton;
   
    public AdminGUI(AdminLoginGUI adminLoginGUI) {
        getContentPane().setBackground(new Color(64, 0, 64));
        setTitle("Admin GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        GridBagConstraints constraints;

        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberLabel.setForeground(new Color(255, 255, 255));
        rollNumberLabel.setBackground(new Color(255, 255, 255));
        rollNumberLabel.setBounds(14, 11, 120, 30);
        rollNumberLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        rollNumberField = new JTextField(20);
        rollNumberField.setBounds(160, 12, 236, 30);
        JLabel nameLabel = new JLabel("First Name:");
        nameLabel.setForeground(new Color(255, 255, 255));
        nameLabel.setBackground(new Color(255, 255, 255));
        nameLabel.setBounds(14, 87, 104, 25);
        nameLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        firstNameField = new JTextField(20);
        firstNameField.setBounds(160, 88, 236, 25);
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setForeground(new Color(255, 255, 255));
        lastNameLabel.setBackground(new Color(255, 255, 255));
        lastNameLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        lastNameLabel.setBounds(14, 123, 87, 24);
        lastNameField = new JTextField(20);
        lastNameField.setBounds(160, 124, 236, 25);
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setForeground(new Color(255, 255, 255));
        dobLabel.setBounds(14, 158, 104, 21);
        dobLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        dobField = new JTextField(20);
        dobField.setBounds(160, 157, 236, 25);
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(new Color(255, 255, 255));
        genderLabel.setBounds(14, 186, 65, 30);
        genderLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        genderField = new JTextField(20);
        genderField.setBounds(160, 193, 236, 25);
        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setForeground(new Color(255, 255, 255));
        departmentLabel.setBounds(14, 265, 104, 25);
        departmentLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        departmentField = new JTextField(20);
        departmentField.setBounds(160, 266, 236, 25);
        JLabel semesterLabel = new JLabel("Semester:");
        semesterLabel.setForeground(new Color(255, 255, 255));
        semesterLabel.setBounds(14, 227, 87, 28);
        semesterLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        semesterField = new JTextField(20);
        semesterField.setBounds(160, 229, 236, 24);
        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setForeground(new Color(255, 255, 255));
        subjectLabel.setBounds(17, 306, 84, 21);
        subjectLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        subjectField = new JTextField(20);
        subjectField.setBounds(160, 305, 236, 25);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(255, 255, 255));
        passwordLabel.setBounds(14, 346, 87, 25);
        passwordLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
        passwordField = new JTextField(20);
        passwordField.setBounds(160, 341, 236, 25);

        JButton viewallButton = new JButton("View All");
        viewallButton.setBounds(652, 404, 87, 30);
        viewallButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        JButton viewButton = new JButton("Search");
        viewButton.setBounds(229, 53, 87, 21);
        viewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(14, 404, 77, 30);
        insertButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(162, 404, 84, 30);
        updateButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(309, 404, 87, 30);
        deleteButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        seatingButton = new JButton("Seating");
        seatingButton.setBounds(474, 404, 90, 30);
        seatingButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

        backButton = new JButton("Back");
        backButton.setBounds(831, 404, 90, 30);
        backButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(408, 11, 566, 370);
        getContentPane().add(scrollPane);

        studentsTable = new JTable();
        scrollPane.setViewportView(studentsTable);
        tableModel = new DefaultTableModel();
        studentsTable.setModel(tableModel);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane.setColumnHeaderView(scrollPane_1);
        tableModel.addColumn("RollNumber");
        tableModel.addColumn("FirstName");
        tableModel.addColumn("LastName");
        tableModel.addColumn("DateOfBirth");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Department");
        tableModel.addColumn("Semester");
        tableModel.addColumn("Subject");


        getContentPane().setLayout(null);
        getContentPane().add(rollNumberLabel);
        getContentPane().add(rollNumberField);
        getContentPane().add(nameLabel);
        getContentPane().add(firstNameField);
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameField);
        getContentPane().add(dobLabel);
        getContentPane().add(dobField);
        getContentPane().add(genderLabel);
        getContentPane().add(genderField);
        getContentPane().add(departmentLabel);
        getContentPane().add(departmentField);
        getContentPane().add(semesterLabel);
        getContentPane().add(semesterField);
        getContentPane().add(subjectLabel);
        getContentPane().add(subjectField);
        getContentPane().add(passwordLabel);
        getContentPane().add(passwordField);
        getContentPane().add(viewallButton);
        getContentPane().add(viewButton);
        getContentPane().add(insertButton);
        getContentPane().add(updateButton);
        getContentPane().add(deleteButton);
        getContentPane().add(seatingButton);
        getContentPane().add(backButton);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudentData();
                fetchStudentData();
            }
        });


        viewallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                clearFields();
                fetchStudentData();
            }
        });
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                insertStudentData();
                clearFields();
                fetchStudentData();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                updateStudentData();
                clearFields();
                fetchStudentData();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                deleteStudentData();
                clearFields();
                fetchStudentData();
            }
        });
        seatingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SeatingArrangementGUI seatingGUI = new SeatingArrangementGUI();
                seatingGUI.setVisible(true);
                setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                adminLoginGUI.setVisible(true);
            }
        });
    }

   
	
	private void clearFields() {
        rollNumberField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        dobField.setText("");
        genderField.setText("");
        departmentField.setText("");
        semesterField.setText("");
        subjectField.setText("");
        passwordField.setText("");
    }

    private void fetchStudentData() {
        String url = "jdbc:mysql://localhost:3306/examhall";
        String username = "root";
        String password = "Sreyas@2002";
        String query = "SELECT * FROM Students ORDER BY RollNumber ASC"; // Modify the query to order by RollNumber in ascending order
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            tableModel.setRowCount(0); // Clear the table

            while (rs.next()) {
                String rollNumber = rs.getString("RollNumber");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String date_of_birth = rs.getString("DateOfBirth");
                String gender = rs.getString("Gender");
                String department = rs.getString("Department");
                String semester = rs.getString("Semester");
                String subject = rs.getString("Subject");
                String pass = rs.getString("Password");

                Object[] rowData = { rollNumber, firstName, lastName, date_of_birth, gender, department, semester, subject};
                tableModel.addRow(rowData);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void viewStudentData() {
        String url = "jdbc:mysql://localhost:3306/examhall";
        String username = "root";
        String password = "Sreyas@2002";
        String rollNumber = rollNumberField.getText();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
         
        
        String query = "SELECT * FROM students WHERE RollNumber = ?";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, rollNumber);

            ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                String roll_number = rs.getString("RollNumber");
              
                rollNumberField.setText(roll_number);
                
                // Update other fields as well
                String firstName = rs.getString("FirstName");
                firstNameField.setText(firstName);
                String lastName = rs.getString("LastName");
                lastNameField.setText(lastName);
                String date_of_birth = rs.getString("DateOfBirth");
                dobField.setText(date_of_birth);
                String gender = rs.getString("Gender");
                genderField.setText(gender);
                String department = rs.getString("Department");
                departmentField.setText(department);
                String semester = rs.getString("Semester");
                semesterField.setText(semester);
                String subject = rs.getString("Subject");
                subjectField.setText(subject);
             
            } else {
                JOptionPane.showMessageDialog(null, "No student found with the provided roll number");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertStudentData() {
        String url = "jdbc:mysql://localhost:3306/examhall";
        String username = "root";
        String password = "Sreyas@2002";
        
        String rollNumber = rollNumberField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String date_of_birth = dobField.getText();
        String gender = genderField.getText();
        String department = departmentField.getText();
        String semester = semesterField.getText();
        String subject = subjectField.getText();
        String pass = passwordField.getText();

        String query = "INSERT INTO students (RollNumber, FirstName, LastName, DateOfBirth, Gender, Department, Semester, Subject, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, rollNumber);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, date_of_birth);
            pstmt.setString(5, gender);
            pstmt.setString(6, department);
            pstmt.setString(7, semester);
            pstmt.setString(8, subject);
            pstmt.setString(9, pass);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void updateStudentData() {
        String url = "jdbc:mysql://localhost:3306/examhall";
        String username = "root";
        String password = "Sreyas@2002";
        String rollNumber = rollNumberField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String date_of_birth = dobField.getText();
        String gender = genderField.getText();
        String department = departmentField.getText();
        String semester = semesterField.getText();
        String subject = subjectField.getText();
        String pass = passwordField.getText();

        String query = "UPDATE students SET FirstName=?, LastName=?, DateOfBirth=?, Gender=?, Department=?, Semester=?, Subject=? WHERE RollNumber=?";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, date_of_birth);
            pstmt.setString(4, gender);
            pstmt.setString(5, department);
            pstmt.setString(6, semester);
            pstmt.setString(7, subject);
            pstmt.setString(8, rollNumber);


            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudentData() {
        String url = "jdbc:mysql://localhost:3306/EXAMHALL";
        String username = "root";
        String password = "Sreyas@2002";
        String rollNumber = rollNumberField.getText();

        String query = "DELETE FROM Students WHERE RollNumber = ?";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, rollNumber);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminGUI frame = new AdminGUI(null);
                    frame.setLocationRelativeTo(null); // Center the window
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
