package nl.betabit.betabit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class login {


    @FXML
    private AnchorPane root;

    @FXML
    private Button backButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

    @FXML
    void Register(ActionEvent event) throws IOException {


        AnchorPane pane = FXMLLoader.load(getClass().getResource("register.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void gotoHomeScreen(ActionEvent event) {

    }

    @FXML
    void logIn(ActionEvent event) throws IOException {

        String username = usernameField.getText();
        String password = passwordField.getText();
        for (User user : Data.getUser()) {
            if (username.equals(user.getMail())) {
                if (password.equals(user.getPassword())) {
                    Session.createSession(username);

                    AnchorPane pane = FXMLLoader.load(getClass().getResource("main.fxml"));
                    root.getChildren().setAll(pane);
                }

            }
        }
    }
}