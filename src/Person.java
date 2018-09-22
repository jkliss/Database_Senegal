import java.sql.Date;

public class Person {
    String firstname;
    String lastname;
    String location;
    Date birthday;
    Date dateOfLastInspection;

    public Date getBirthday() {
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
