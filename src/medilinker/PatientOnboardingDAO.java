package medilinker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
 
public class PatientOnboardingDAO {
    private Connection conn;
    
 
    public PatientOnboardingDAO() {
        // code to connect to the MySQL database 
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tellymedic360", "root", "Sinix@004");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 //method to add new patient into the database
    public void addNewPatient(String patient_id, String firstName, String lastName, String gender, String dateOfBirth, String email, String sickness, String emergencyContactInfo) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tellymedic360", "root", "Sinix@004");
            // Make sure 'patient_id' matches the exact column name in your database
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO patients (patient_id, first_name, last_name, gender, date_of_birth, email, sickness, emergency_contact_info) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, patient_id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, gender);
            stmt.setString(5, dateOfBirth);
            stmt.setString(6, email);
            stmt.setString(7, sickness);
            stmt.setString(8, emergencyContactInfo);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Patient record added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 //method to edit Patient information inacse theres been a mistake in entering patient record
    public void editPatient(int patient_id, String firstName, String lastName, String gender, String dateOfBirth, String email, String Sickness, String emergencyContactInfo) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tellymedic360", "root", "Sinix@004");
        PreparedStatement stmt = conn.prepareStatement("UPDATE patients SET first_name = ?, last_name = ?, gender = ?, date_of_birth = ?, email = ?, sickness = ?, emergency_contact_info = ? WHERE patient_id = ?");
        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        stmt.setString(3, gender);
        stmt.setString(4, dateOfBirth);
        stmt.setString(5, email);
        stmt.setString(6, Sickness); // Assuming this sets the sickness
        stmt.setString(7, emergencyContactInfo);
        stmt.setInt(8, patient_id); // Assuming patient_id is the primary key
        stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

 // to delete patient history
    public void deletePatient(int patientId) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tellymedic360", "root", "Sinix@004");
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM patients WHERE patient_id = ?");
            stmt.setInt(1, patientId);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Patient record deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
        public List<Patient> viewPatient() {
        List<Patient> patients = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tellymedic360", "root", "Sinix@004");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM patients");
            ResultSet result = stmt.executeQuery();
 
            while (result.next()) {
                int patient_id = result.getInt("patient_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String gender = result.getString("gender");
                Date dateOfBirth = result.getDate("date_of_birth"); // Assuming date_of_birth is a DATE type in your database
                String email = result.getString("email");
                String sickness = result.getString("sickness");
                String emergencyContactInfo = result.getString("emergency_contact_info");
 
                // Create a Patient object and populate its attributes
                Patient patient = new Patient();
                patient.setPatient_id(patient_id);
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setGender(gender);
                patient.setDateOfBirth(dateOfBirth);
                patient.setEmail(email);
                patient.setSickness(sickness);
                patient.setEmergencyContactInfo(emergencyContactInfo);
 
                // Add the patient object to the list
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., log the error, display a message to the user)
        }
        return patients;
    }
    
    

// the method to add new and updated sickness information into the database
  public void addSicknessInfo(String sickness, String description, String recommendedFoods, String notRecommendedFoods, String exercise) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tellymedic360", "root", "Sinix@004");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO sickness_list (sickness, description, recommended_foods, not_recommended_foods, exercise) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, sickness);
            stmt.setString(2, description);
            stmt.setString(3, recommendedFoods);
            stmt.setString(4, notRecommendedFoods);
            stmt.setString(5, exercise);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sickness information added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  //method to add patients medical history into the database
     public void addMedicalHistory(int patient_id, String medical_history) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ehrs (patient_id, medical_history) VALUES (?, ?)");
            stmt.setInt(1, patient_id);
            stmt.setString(2, medical_history);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medical History added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     // the method used to obtain medical history about the patient
      public String getMedicalHistory(int patient_id) {
        String medical_history = "";
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT medical_history FROM ehrs WHERE patient_id = ?");
            stmt.setInt(1, patient_id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                medical_history = result.getString("medical_history");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medical_history;
    }
    //method to view patient stored in the database
    public List<Sickness> getSicknessList() {
    List<Sickness> sicknessList = new ArrayList<>();
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tellymedic360", "root", "Sinix@004");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM sickness_list");
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            Sickness sickness = new Sickness();
            sickness.setSicknessName(result.getString("sickness"));
            sickness.setDescription(result.getString("description"));
            sickness.setRecommendedFoods(result.getString("recommended_foods"));
            sickness.setNotRecommendedFoods(result.getString("not_recommended_foods"));
            sickness.setExercises(result.getString("exercise"));
            sicknessList.add(sickness);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sicknessList;
}



}

//Class is responsible for performing database operations related to patient onboarding process
//provides methods to add new patient, edit patient , view a list of patients, add manage , medical history , and sickness information
//Class establishes a connection to MYSQL database using the provided credentials                                                                             








