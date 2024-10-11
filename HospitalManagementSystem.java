import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class HospitalManagementSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_management_system";
    private static final String USER = "root"; // Change if needed
    private static final String PASSWORD = "gj10ar3638"; //  MySQL password

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hospital Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 300);
            frame.setLayout(new BorderLayout());

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane, BorderLayout.CENTER);

            JPanel panel = new JPanel();
            JButton addButton = new JButton("Add Patient");
            JButton viewButton = new JButton("View Patients");
            JButton updateButton = new JButton("Update Patient");
            JButton deleteButton = new JButton("Delete Patient");

            panel.add(addButton);
            panel.add(viewButton);
            panel.add(updateButton);
            panel.add(deleteButton);
            frame.add(panel, BorderLayout.SOUTH);

            addButton.addActionListener(e -> addPatient());
            viewButton.addActionListener(e -> viewPatients(textArea));
            updateButton.addActionListener(e -> updatePatient());
            deleteButton.addActionListener(e -> deletePatient());

            frame.setVisible(true);
        });
    }

    private static void addPatient() {
        JTextField nameField = new JTextField(20);
        JTextField ageField = new JTextField(20);
        JTextField genderField = new JTextField(20);
        JTextField diseaseField = new JTextField(20);
        JTextField dateField = new JTextField(20);
        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderField);
        panel.add(new JLabel("Disease:"));
        panel.add(diseaseField);
        panel.add(new JLabel("Admission Date (YYYY-MM-DD):"));
        panel.add(dateField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Patient", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            String disease = diseaseField.getText();
            String admissionDate = dateField.getText();

            String query = "INSERT INTO patients (name, age, gender, disease, admission_date) VALUES (?, ?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, gender);
                pstmt.setString(4, disease);
                pstmt.setDate(5, Date.valueOf(admissionDate));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Patient added successfully!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error adding patient: " + e.getMessage());
            }
        }
    }

    private static void viewPatients(JTextArea textArea) {
        String query = "SELECT * FROM patients";
        StringBuilder sb = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            sb.append("Patients List:\n");
            while (rs.next()) {
                sb.append(String.format("ID: %d, Name: %s, Age: %d, Gender: %s, Disease: %s, Admission Date: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("gender"), rs.getString("disease"), rs.getDate("admission_date")));
            }
            textArea.setText(sb.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error viewing patients: " + e.getMessage());
        }
    }

    private static void updatePatient() {
        JTextField idField = new JTextField(20);
        JTextField nameField = new JTextField(20);
        JTextField ageField = new JTextField(20);
        JTextField genderField = new JTextField(20);
        JTextField diseaseField = new JTextField(20);
        JTextField dateField = new JTextField(20);
        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Patient ID:"));
        panel.add(idField);
        panel.add(new JLabel("New Name:"));
        panel.add(nameField);
        panel.add(new JLabel("New Age:"));
        panel.add(ageField);
        panel.add(new JLabel("New Gender:"));
        panel.add(genderField);
        panel.add(new JLabel("New Disease:"));
        panel.add(diseaseField);
        panel.add(new JLabel("New Admission Date (YYYY-MM-DD):"));
        panel.add(dateField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Update Patient", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            String disease = diseaseField.getText();
            String admissionDate = dateField.getText();

            String query = "UPDATE patients SET name=?, age=?, gender=?, disease=?, admission_date=? WHERE id=?";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, gender);
                pstmt.setString(4, disease);
                pstmt.setDate(5, Date.valueOf(admissionDate));
                pstmt.setInt(6, id);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No patient found with ID: " + id);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating patient: " + e.getMessage());
            }
        }
    }

    private static void deletePatient() {
        JTextField idField = new JTextField(20);
        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Patient ID:"));
        panel.add(idField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Patient", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());

            String query = "DELETE FROM patients WHERE id=?";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Patient deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No patient found with ID: " + id);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting patient: " + e.getMessage());
            }
        }
    }
}
