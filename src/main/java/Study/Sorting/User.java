package Study.Sorting;

public class User {
    private String firstName;
    private String lastName;
    private String msisdn;
    private String email;

    public User(String firstName, String lastName, String msisdn, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.msisdn = msisdn;
        this.email = email;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String toString() {
        return firstName + " " + lastName + " " + msisdn + " " + email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
