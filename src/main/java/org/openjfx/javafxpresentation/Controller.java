package org.openjfx.javafxpresentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label loginText;

    @FXML
    protected void onButtonClick() {
        loginText.setText("You have successfully logged in.");
    }
}