package medilinker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PatientOnboarding extends JFrame implements ActionListener {
    private PatientOnboardingDAO dao;
    private Connection conn;
    private JTextField patient_idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField genderTextField;
    private JTextField dateOfBirthTextField;
    private JTextField emailTextField;
    private JTextField sicknessTextField;
    private JTextField emergencyContactTextField;
    private  JButton deleteButton;
    private  JButton  ViewButton;
    private JButton editButton;
    private JButton SicknessList;
    private JButton addSicknessInfo;
    private JButton addMedicalHistoryButton;
    private JButton viewMedicalHistoryButton;
    private UserRegistration userRegistration;
    public PatientOnboarding() {
        dao = new PatientOnboardingDAO();
        userRegistration = new UserRegistration();
        setLayout(new FlowLayout());
        
        patient_idTextField= new JTextField(20);
        firstNameTextField = new JTextField(20);
        lastNameTextField = new JTextField(20);
        genderTextField = new JTextField(20);
        dateOfBirthTextField = new JTextField(20);
        emailTextField = new JTextField(20);
        sicknessTextField = new JTextField(20);
        emergencyContactTextField = new JTextField(20);
        deleteButton = new JButton("Delete");
        ViewButton = new JButton("View Patient");
        editButton = new JButton("Edit Patient");
        addSicknessInfo = new JButton("addSicknessInfo");
        addMedicalHistoryButton = new JButton("addMedicalHistory");
        viewMedicalHistoryButton = new JButton("viewMedicalHistory");
        
        
        
        add(new JLabel("Patient ID:"));
        patient_idTextField = new JTextField(20);
        add(patient_idTextField);

        add(new JLabel("First Name:"));
        firstNameTextField = new JTextField(20);
        add(firstNameTextField);

        add(new JLabel("Last Name:"));
        lastNameTextField = new JTextField(20);
        add(lastNameTextField);

        add(new JLabel("Gender:"));
        genderTextField = new JTextField(20);
        add(genderTextField);

        add(new JLabel("Date of Birth:"));
        dateOfBirthTextField = new JTextField(20);
        add(dateOfBirthTextField);

        add(new JLabel("Email:"));
        emailTextField = new JTextField(20);
        add(emailTextField);
        
        add(new JLabel("Sickness:"));
        sicknessTextField = new JTextField(20);
        add(sicknessTextField);

        add(new JLabel("Emergency Contact Info:"));
        emergencyContactTextField = new JTextField(20);
        add(emergencyContactTextField);

        JButton addNewPatientButton = new JButton("Add New Patient");
        addNewPatientButton.addActionListener(new AddNewPatientButtonListener());
        add(addNewPatientButton);
        
        deleteButton = new JButton("Delete");
        JButton deleteButton = new JButton("Delete Patient");
        deleteButton.addActionListener(new DeletePatientButtonListener());
        add(deleteButton);
        
         ViewButton = new JButton("View Patient");
        ViewButton.addActionListener(this);
        add(ViewButton);
        
        JButton editButton = new JButton("Edit Patient");
        editButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                editPatient();
            }
        
        });
       add(editButton);
        
                
        JButton sicknessListButton = new JButton("Sickness List");
        sicknessListButton.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                displaySicklistInfo();
            }
        });
        add(sicknessListButton);
   
    JButton addSicknessInfoButton = new JButton("add SicknessInfo");
        addSicknessInfoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addSicknessInfo();
            }
        
        });
       add(addSicknessInfoButton);
       
        JButton getMedicalHistoryButton = new JButton("getMedicalHistory");
       getMedicalHistoryButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                getMedicalHistory();
            }

            private void getMedicalHistory() {
                
            }
        
        });
   
    addMedicalHistoryButton = new JButton("Add Medical History");
        addMedicalHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedicalHistory();
            }
        });
        add(addMedicalHistoryButton);
    viewMedicalHistoryButton = new JButton("View Medical History");
        viewMedicalHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMedicalHistory();
            }
        });
        add(viewMedicalHistoryButton);
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performRegistration();
            }
        });
        add(registerButton);

    
    }
// the method to add new medical history of patients into database
    public void addMedicalHistory() {
        int patient_id = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID:"));
        String medical_history = JOptionPane.showInputDialog("Enter medical history:");
        PatientOnboardingDAO dao = new PatientOnboardingDAO();
        dao.addMedicalHistory(patient_id, medical_history);
    }
        public void viewMedicalHistory() {
        int patient_id = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID:"));
        PatientOnboardingDAO dao = new PatientOnboardingDAO();
        String medical_history = dao.getMedicalHistory(patient_id);
        JOptionPane.showMessageDialog(null, "Patient Medical History:\n" + medical_history);
    }

        private void performLogin() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");

        if (userRegistration.login(username, password)) {
            JOptionPane.showMessageDialog(null, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        }
    }

    private void performRegistration() {
        String username = JOptionPane.showInputDialog("Enter a username:");
        String password = JOptionPane.showInputDialog("Enter a password:");

        userRegistration.registerUser(username, password);
    }



    // method call from PatientOnboardingDAO to add new  sicknessInfo  into database
        public void addSicknessInfo() {
        String sickness = JOptionPane.showInputDialog("Enter the sickness name:");
        String description = JOptionPane.showInputDialog("Enter the description:");
        String recommendedFoods = JOptionPane.showInputDialog("Enter the recommended foods:");
        String notRecommendedFoods = JOptionPane.showInputDialog("Enter the not recommended foods:");
        String exercise = JOptionPane.showInputDialog("Enter the exercise:");

        dao.addSicknessInfo(sickness, description, recommendedFoods, notRecommendedFoods, exercise);
    }
        
        
        
        
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ViewButton) {
            viewPatient();
        }
    }
// method call for PatientOnboardingDAO to display sicknessInfo saved in database
    private void displaySicklistInfo() {
        PatientOnboardingDAO dao = new PatientOnboardingDAO();
        java.util.List<Sickness> sicknessList = dao.getSicknessList();

        if (sicknessList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sickness information found.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Sickness sickness : sicknessList) {
            sb.append("Sickness Name: ").append(sickness.getSicknessName()).append("\n");
            sb.append("Description: ").append(sickness.getDescription()).append("\n");
            sb.append("Recommended Foods: ").append(sickness.getRecommendedFoods()).append("\n");
            sb.append("Not Recommended Foods: ").append(sickness.getNotRecommendedFoods()).append("\n");
            sb.append("Exercises: ").append(sickness.getExercises()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    private void viewPatient() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tellymedic360", "root", "Sinix@004");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM patients");
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int patient_id = result.getInt("patient_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String gender = result.getString("gender");
                String dateOfBirth = result.getString("date_of_birth");
                String email = result.getString("email");
                String sickness = result.getString("sickness");
                String emergencyContactInfo = result.getString("emergency_contact_info");

                System.out.println("Patient ID: " + patient_id);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Gender: " + gender);
                System.out.println("Date of Birth: " + dateOfBirth);
                System.out.println("Email: " + email);
                System.out.println("Sickness: " + sickness);
                System.out.println("Emergency Contact Info: " + emergencyContactInfo);
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editPatient() {
      System.out.println("Edit button clicked"); // Debugging line
      // 2. Data Retrieval: Get data from input fields
      int patient_id = Integer.parseInt(patient_idTextField.getText());
      String firstName = firstNameTextField.getText();
      String lastName = lastNameTextField.getText();
      String gender = genderTextField.getText();
      String dateOfBirth = dateOfBirthTextField.getText();
      String email = emailTextField.getText();
      String sickness = sicknessTextField.getText();
      String emergencyContactInfo = emergencyContactTextField.getText();
      // Create an instance of your DAO
      PatientOnboardingDAO dao = new PatientOnboardingDAO();
      // Call the editPatient method
      dao.editPatient(patient_id, firstName, lastName, gender,
              dateOfBirth, email, sickness, emergencyContactInfo);
      JOptionPane.showMessageDialog(null, "Patient record updated successfully!");
      
    }
    private class DeletePatientButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int patient_id = Integer.parseInt(patient_idTextField.getText());
            PatientOnboardingDAO dao = new PatientOnboardingDAO();
            dao.deletePatient(patient_id);
        }
    }
    

    
    private class AddNewPatientButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String patient_id = patient_idTextField.getText();
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String gender = genderTextField.getText();
            String dateOfBirth = dateOfBirthTextField.getText();
            String email = emailTextField.getText();
            String emergencyContactInfo = emergencyContactTextField.getText();
            String sickness = sicknessTextField.getText();

            PatientOnboardingDAO dao = new PatientOnboardingDAO();
            dao.addNewPatient(patient_id,firstName, lastName, gender, dateOfBirth, email,sickness, emergencyContactInfo);
        }
    }

    public static void main(String[] args) {
        PatientOnboarding frame = new PatientOnboarding();
        frame.setTitle("Patient Onboarding");
        frame.setSize(400, 500);
        frame.setVisible(true);
    }
}

 // This is the main user interface for the patient onboarding process
//This class creates a GUI with text fields, buttons, and other components to allow the user to input patient , information, perform
//various operations(add, edit, delete, view) and interact with the application
//it uses the PatientDAO class to communicate with the databse and perform the necessary operations
//Class also includes functionality for user registration and login , which is handled by the userRegistration class