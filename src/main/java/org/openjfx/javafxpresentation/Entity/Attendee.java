package org.openjfx.javafxpresentation.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Attendee.
 */
@Entity
@Table(name = "madison042025")
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "email_optin")
    private boolean emailOptIn;
    @Column(name = "phone")
    private int phone;
    @Column(name = "phone_optin")
    private boolean phoneOptIn;

    /**
     * Instantiates a new Attendee.
     */
    public Attendee() {
    }

    /**
     * Instantiates a new Attendee.
     *
     * @param id         the id
     * @param firstName  the first name
     * @param lastName   the last name
     * @param email      the email
     * @param emailOptIn the email opt in
     * @param phone      the phone
     * @param phoneOptIn the phone opt in
     */
    public Attendee(int id, String firstName, String lastName, String email, boolean emailOptIn, int phone, boolean phoneOptIn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.emailOptIn = emailOptIn;
        this.phone = phone;
        this.phoneOptIn = phoneOptIn;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Is email opt in boolean.
     *
     * @return the boolean
     */
    public boolean isEmailOptIn() {
        return emailOptIn;
    }

    /**
     * Sets email opt in.
     *
     * @param emailOptIn the email opt in
     */
    public void setEmailOptIn(boolean emailOptIn) {
        this.emailOptIn = emailOptIn;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Is phone opt in boolean.
     *
     * @return the boolean
     */
    public boolean isPhoneOptIn() {
        return phoneOptIn;
    }

    /**
     * Sets phone opt in.
     *
     * @param phoneOptIn the phone opt in
     */
    public void setPhoneOptIn(boolean phoneOptIn) {
        this.phoneOptIn = phoneOptIn;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", emailOptIn=" + emailOptIn +
                ", phone=" + phone +
                ", phoneOptIn=" + phoneOptIn +
                '}';
    }
}