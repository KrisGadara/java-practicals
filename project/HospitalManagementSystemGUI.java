import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystemGUI {
    private List<Patient> patientList = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalManagementSystemGUI().createAndShowGUI());
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
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
    }

    private void addPatient() {
        JTextField nameField = new JTextField(20);
        JTextField ageField = new JTextField(20);
        JTextField genderField = new JTextField(20);
        JTextField diseaseField = new JTextField(20);
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderField);
        panel.add(new JLabel("Disease:"));
        panel.add(diseaseField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Patient", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            int age;
            try {
                age = Integer.parseInt(ageField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Age. Please enter a number.");
                return;
            }
            String gender = genderField.getText();
            String disease = diseaseField.getText();

            patientList.add(new Patient(name, age, gender, disease));
            JOptionPane.showMessageDialog(null, "Patient added successfully!");
        }
    }

    private void viewPatients(JTextArea textArea) {
        if (patientList.isEmpty()) {
            textArea.setText("No patients found.");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Patient List:\n");
            for (Patient patient : patientList) {
                sb.append(String.format("ID: %d, Name: %s, Age: %d, Gender: %s, Disease: %s%n",
                        patient.getId(), patient.getName(), patient.getAge(), patient.getGender(), patient.getDisease()));
            }
            textArea.setText(sb.toString());
        }
    }

    private void updatePatient() {
        String idStr = JOptionPane.showInputDialog("Enter Patient ID to Update:");
        if (idStr == null || !idStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Invalid ID.");
            return;
        }
        int id = Integer.parseInt(idStr);
        Patient patient = findPatientById(id);
        if (patient == null) {
            JOptionPane.showMessageDialog(null, "Patient not found.");
            return;
        }

        JTextField nameField = new JTextField(patient.getName(), 20);
        JTextField ageField = new JTextField(String.valueOf(patient.getAge()), 20);
        JTextField genderField = new JTextField(patient.getGender(), 20);
        JTextField diseaseField = new JTextField(patient.getDisease(), 20);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderField);
        panel.add(new JLabel("Disease:"));
        panel.add(diseaseField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Update Patient", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            patient.setName(nameField.getText());
            try {
                patient.setAge(Integer.parseInt(ageField.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Age.");
                return;
            }
            patient.setGender(genderField.getText());
            patient.setDisease(diseaseField.getText());
            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
        }
    }

    private void deletePatient() {
        String idStr = JOptionPane.showInputDialog("Enter Patient ID to Delete:");
        if (idStr == null || !idStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Invalid ID.");
            return;
        }
        int id = Integer.parseInt(idStr);
        Patient patient = findPatientById(id);
        if (patient != null) {
            patientList.remove(patient);
            JOptionPane.showMessageDialog(null, "Patient deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Patient not found.");
        }
    }

    private Patient findPatientById(int id) {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    class Patient {
        private static int idCounter = 1;
        private int id;
        private String name;
        private int age;
        private String gender;
        private String disease;

        public Patient(String name, int age, String gender, String disease) {
            this.id = idCounter++;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.disease = disease;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public String getDisease() {
            return disease;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }
    }
}
