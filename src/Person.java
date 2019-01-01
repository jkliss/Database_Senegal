import javafx.collections.ObservableArray;

import java.sql.Date;

public class Person {
    String date;
    String treatment;
    String village;
    String address;
    String email;
    String telephone;
    String birthday;
    String firstname;
    String lastname;
    String location;
    int patientID;
    Date dateOfLastInspection;

    public Person(String firstname, String lastname, String location){
        this.firstname = firstname;
        this.lastname = lastname;
        this.location = location;
    }

    public Person(String firstname, String lastname, String date, String treatment, String village, String birthday, String address, String email, String telephone){
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.treatment = treatment;
        this.village = village;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    public Person(int patientID, String firstname, String lastname, String treatment, String birthday, String address, String email, String telephone){
        this.patientID = patientID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.treatment = treatment;
    }



    public String getBirthday() {
        return birthday;
    }

    public Date getDateOfLastInspection() {
        return dateOfLastInspection;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail(){
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getDate() {
        return date;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getVillage() {
        return village;
    }

    public void setDateOfLastInspection(Date dateOfLastInspection) {
        this.dateOfLastInspection = dateOfLastInspection;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
