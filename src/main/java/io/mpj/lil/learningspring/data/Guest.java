package io.mpj.lil.learningspring.data;

import javax.persistence.*;

@Entity
@Table(name="GUEST")
public class Guest {
    @Id
    @GeneratedValue
    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="STATE")
    private String state;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    @Override
    public String toString() {
        return "Guest{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
