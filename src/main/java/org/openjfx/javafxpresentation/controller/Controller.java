package org.openjfx.javafxpresentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import org.openjfx.javafxpresentation.entity.Attendee;
import org.openjfx.javafxpresentation.persistence.GenericDAO;

/**
 * The type Controller.
 */
public class Controller {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private CheckBox emailOptIn;
    @FXML
    private CheckBox phoneOptIn;

    @FXML
    private void handleSignUp(ActionEvent event) {
        // Extract form data.
        Attendee attendee = new Attendee();
        attendee.setFirstName(firstName.getText());
        attendee.setLastName(lastName.getText());
        attendee.setEmail(email.getText());
        attendee.setPhone(phone.getText());
        attendee.setEmailOptIn(emailOptIn.isSelected());
        attendee.setPhoneOptIn(phoneOptIn.isSelected());

        // Add to database.
        GenericDAO<Attendee> dao = new GenericDAO<>(Attendee.class);
        dao.insert(attendee);

        // Reset the form after submission.
        resetForm();
    }

    private void resetForm() {
        firstName.clear();  // Clears the text field
        lastName.clear();   // Clears the text field
        email.clear();      // Clears the text field
        phone.clear();      // Clears the text field
        emailOptIn.setSelected(false);  // Unselects the checkbox
        phoneOptIn.setSelected(false);  // Unselects the checkbox
    }
}
