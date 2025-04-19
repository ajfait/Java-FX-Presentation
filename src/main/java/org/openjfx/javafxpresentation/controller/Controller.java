package org.openjfx.javafxpresentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The type Controller.
 */
public class Controller {
    @FXML
    private Label loginText;

    /**
     * On button click.
     */
    @FXML
    protected void onButtonClick() {
        loginText.setText("You have successfully logged in.");
    }
}