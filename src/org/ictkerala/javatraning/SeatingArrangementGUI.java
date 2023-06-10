package org.ictkerala.javatraning;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SeatingArrangementGUI extends JFrame {
    private JLabel lblTotalClasses;
    private JTextField txtTotalClasses;
    private JLabel lblTotalStudents;
    private JTextField txtTotalStudents;
    private JButton btnEnterClassDetails;
    private JButton btnGenerate;
    private JButton btnBack;
    private JTabbedPane tabbedPane;

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/examhall";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Sreyas@2002";

    private int currentTabIndex = 0;

    public SeatingArrangementGUI() {
        getContentPane().setBackground(new Color(128, 0, 255));
        initializeUI();
  
    }
    private void initializeUI() {
        setTitle("Exam Seating Arrangement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 560);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new FlowLayout());

        lblTotalClasses = new JLabel("Total Classes:");
        lblTotalClasses.setFont(new Font("Gadugi", Font.BOLD, 13));
        txtTotalClasses = new JTextField(10);
        lblTotalStudents = new JLabel("Total Students:");
        lblTotalStudents.setFont(new Font("Gadugi", Font.BOLD, 13));
        txtTotalStudents = new JTextField(10);
        btnEnterClassDetails = new JButton("Enter Class Details");
        btnEnterClassDetails.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        btnGenerate = new JButton("Generate Seating Arrangement");
        btnGenerate.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        tabbedPane = new JTabbedPane();

        btnEnterClassDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterClassDetails();
            }
        });

        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateSeatingArrangement();
            }
        });
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBackToClassDetails();
            }
        });
        getContentPane().add(btnBack);
        getContentPane().add(lblTotalClasses);
        getContentPane().add(txtTotalClasses);
        getContentPane().add(lblTotalStudents);
        getContentPane().add(txtTotalStudents);
        getContentPane().add(btnEnterClassDetails);
        getContentPane().add(tabbedPane);
        getContentPane().add(btnGenerate);
        getContentPane().add(btnBack);
        setVisible(true);
    }

    private void enterClassDetails() {
        int totalClasses = Integer.parseInt(txtTotalClasses.getText());

        for (int i = 0; i < totalClasses; i++) {
            JPanel classPanel = new JPanel(new GridLayout(3, 2));

            JTextField txtClassName = new JTextField(10);
            JTextField txtStudents = new JTextField(10);
            JTextField txtRows = new JTextField(10);

            classPanel.add(new JLabel("Class Name:"));
            classPanel.add(txtClassName);
            classPanel.add(new JLabel("Number of Students:"));
            classPanel.add(txtStudents);
            classPanel.add(new JLabel("Number of Rows:"));
            classPanel.add(txtRows);

            tabbedPane.addTab("Class " + (i + 1), classPanel);
        }

        currentTabIndex = totalClasses - 1;
        revalidate();
        repaint();
    }

    private void generateSeatingArrangement() {
        int totalClasses = tabbedPane.getTabCount();
        int currentClassIndex = 0;
        int currentSeatNumber = 1;

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            while (currentClassIndex < totalClasses) {
                JPanel classPanel = (JPanel) tabbedPane.getComponentAt(currentClassIndex);
                JTextField txtClassName = (JTextField) classPanel.getComponent(1);
                JTextField txtStudents = (JTextField) classPanel.getComponent(3);
                JTextField txtRows = (JTextField) classPanel.getComponent(5);

                String className = txtClassName.getText();
                int totalStudents = Integer.parseInt(txtStudents.getText());
                int totalRows = Integer.parseInt(txtRows.getText());

                PreparedStatement selectStatement = connection.prepareStatement("SELECT RollNumber, Semester FROM Students ORDER BY Semester, RollNumber");
                ResultSet resultSet = selectStatement.executeQuery();

                while (resultSet.next()) {
                    String rollNumber = resultSet.getString("RollNumber");
                    String semester = resultSet.getString("Semester");

                    if (currentSeatNumber > totalStudents) {
                        currentClassIndex++;
                        if (currentClassIndex >= totalClasses) {
                            break;
                        }

                        classPanel = (JPanel) tabbedPane.getComponentAt(currentClassIndex);
                        txtClassName = (JTextField) classPanel.getComponent(1);
                        txtStudents = (JTextField) classPanel.getComponent(3);
                        txtRows = (JTextField) classPanel.getComponent(5);
                        className = txtClassName.getText();
                        totalStudents = Integer.parseInt(txtStudents.getText());
                        totalRows = Integer.parseInt(txtRows.getText());

                        currentSeatNumber = 1;
                    }

                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE Students SET SeatNumber = ?, Class = ? WHERE RollNumber = ?");
                    updateStatement.setInt(1, currentSeatNumber);
                    updateStatement.setString(2, className);
                    updateStatement.setString(3, rollNumber);
                    updateStatement.executeUpdate();

                    currentSeatNumber++;
                }

                resultSet.close();
                selectStatement.close();
            }

            // Display seating arrangement tables for each class
            for (int i = 0; i < totalClasses; i++) {
                JPanel classPanel = (JPanel) tabbedPane.getComponentAt(i);
                String className = ((JTextField) classPanel.getComponent(1)).getText();
                int totalRows = Integer.parseInt(((JTextField) classPanel.getComponent(5)).getText());
                int totalColumns = (int) Math.ceil((double) Integer.parseInt(((JTextField) classPanel.getComponent(3)).getText()) / totalRows);

                PreparedStatement selectSeatsStatement = connection.prepareStatement("SELECT RollNumber FROM Students WHERE Class = ? ORDER BY SeatNumber");
                selectSeatsStatement.setString(1, className);
                ResultSet seatsResultSet = selectSeatsStatement.executeQuery();

                JTable table = new JTable(totalColumns, totalRows); // Interchanged rows and columns
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int row = 0, col = 0;
                while (seatsResultSet.next()) {
                    String rollNumber = seatsResultSet.getString("RollNumber");
                    model.setValueAt(rollNumber, col, row); // Interchanged row and column

                    col++;
                    if (col >= totalColumns) {
                        col = 0;
                        row++;
                    }
                }

                JScrollPane scrollPane = new JScrollPane(table);
                tabbedPane.setComponentAt(i, scrollPane);

                seatsResultSet.close();
                selectSeatsStatement.close();
            }

            connection.close();

            JOptionPane.showMessageDialog(this, "Seating arrangement generated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void goBackToClassDetails() {
        int totalTabs = tabbedPane.getTabCount();
        if (totalTabs > 1) {
            tabbedPane.remove(currentTabIndex);
            currentTabIndex--;

            revalidate();
            repaint();
        } else {
            // If there's only one tab left, navigate to the admin GUI
            setVisible(false);
            AdminGUI adminGUI = new AdminGUI(null);
            adminGUI.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SeatingArrangementGUI();
            }
        });
    }
}
