package medilinker;

import java.util.Date;
public class Patient {
    // The patient attributes
    private int patient_id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String sickness;
    private String email;
    private String emergencyContactInfo;
    // The contructor
    public Patient(int patient_id1, String firstName1, String lastName1, String gender1, String dateOfBirth1,String sickness, String email1, String emergencyContactInfo1) {}

   public Patient(  int patient_id,String firstName, String lastName, String gender, Date dateOfBirth, String email, String sickness, String emergencyContactInfo) {
        this.patient_id = patient_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.sickness = sickness;
        this.email = email;
        this.emergencyContactInfo = emergencyContactInfo;
    }

    Patient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

// These are the getter and setter methods
    public int patient_id(){
        return patient_id;
    }
    public void setPatient_id(int patient_id){
    this.patient_id = patient_id;
}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setSickness(String sickness){
        this.sickness = sickness;
    }
    public String getSickness(){
        return sickness;
    }
    public String getEmergencyContactInfo() {
        return emergencyContactInfo;
    }

    public void setEmergencyContactInfo(String emergencyContactInfo) {
        this.emergencyContactInfo = emergencyContactInfo;
    }

    void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
//represents and defines the propertiesof a patient
//it also has getter and setter methods for each of all the patient attributes eg patient ID..
//as well as Contructor methods to create new patient objects