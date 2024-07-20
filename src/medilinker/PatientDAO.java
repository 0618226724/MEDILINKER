package medilinker;

import java.sql.*;

public class PatientDAO {
    private Connection conn;

    public PatientDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tellymedic360", "root", "Sinix@004");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//method to adding new patient into the database 
    public void addNewPatient(Patient patient, String patient_id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO patients (patient_id ,first_name, last_name, gender, date_of_birth, email,sickness, emergency_contact_info) VALUES (?, ?, ?, ?, ?, ?,?)");
            stmt.setString(1, patient_id);
            stmt.setString(2, patient.getFirstName());
            stmt.setString(3, patient.getLastName());
            stmt.setString(4, patient.getGender());
            stmt.setDate(5, (Date) patient.getDateOfBirth());
            stmt.setString(6, patient.getEmail());
            stmt.setString(7,patient.getSickness());
            stmt.setString(8, patient.getEmergencyContactInfo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
    }
//method to view all patients in the database and their related information
    public ResultSet viewPatient() {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM patients");
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
// method to edit or rather update patient information stored in the database 
    public void editPatient(int patient_id, String firstName, String lastName, String gender, String dateOfBirth, String email, String Sickness, String emergencyContactInfo) {
    try {
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
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// the delete patient method from the database 
    public void deletePatient(int patient_id) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tellymedic360", "root", "Sinix@004");
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM patients WHERE patient_id = ?");
            stmt.setInt(1,patient_id);
            stmt.executeUpdate();
        }catch (SQLException e){
           
        }
}

    void addNewPatient(String patient_id, String firstName, String lastName, String gender, String dateOfBirth, String email, String emergencyContactInfo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

        

}

// Class respponsible for interacting with the database to per CRUD(create, Read , Update, Delete)Operations
//Class Contains methods to add new patient's information, view all exixting patient information in the database, and delete a patient from the database
// Class establishes a connection to the MySQL database making use of provided credentials