package nl.betabit.betabit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class register {

    private final StringChecker stringChecker = new StringChecker();

    @FXML
    private TextField fullname;

    @FXML
    private TextField mail;

    @FXML
    private Button onRegister;

    @FXML
    private PasswordField password;

    @FXML
    private TextField position;

    @FXML
    private PasswordField repeatbutton;

    @FXML
    private AnchorPane root;

    @FXML
    void onRegister(ActionEvent event) throws IOException {

        String username = mail.getText();
        String fullname1 = fullname.getText();
        String password1 = password.getText();
        String password2 = repeatbutton.getText();
        String position1 = position.getText();

        if(stringChecker.isFullName(fullname1)) {
            if (password1.equals(password2)) {
                if (!stringChecker.alreadyRegistered(username) && stringChecker.isValid(username)) {
                    Data.addUser(new User(username, fullname1, position1, password1));
                    Data.addUserData(new UserData(0, 0, 0, username, 0));

                    Session.createSession(username);
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("main.fxml"));
                    root.getChildren().setAll(pane);
                }
            }
        }
    }


}