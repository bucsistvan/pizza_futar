package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@NamedQuery(name = Courier.FIND_BY_USERNAME, query = "select u from Courier u where u.firstName=:firstName and u.lastName=:lastName ")
@Entity
@Table
public class Courier extends AbstractCompany {

    public static  final String FIND_BY_USERNAME = "Courier.findByUsername";

    @Column(name = "first_name", nullable = false, length = 500)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 500)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courier courier = (Courier) o;

        String oFullName = null;
        if (firstName != null && lastName != null) {
            oFullName = firstName + " " + lastName;
        }
        String fullName = firstName+" "+lastName;

        if (getId() != null ? !getId().equals(courier.getId()) : courier.getId() != null) return false;
        return Objects.equals(fullName, oFullName);
    }

    @Override
    public int hashCode() {
        String fullName = null;
        if (firstName != null && lastName != null) {
            fullName = firstName + " " + lastName;
        }
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courier)) return false;
        Courier courier = (Courier) o;
        return Objects.equals(firstName, courier.firstName) && Objects.equals(lastName, courier.lastName) && Objects.equals(phoneNumber, courier.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }
}
