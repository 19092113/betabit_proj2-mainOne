package nl.betabit.betabit;

import com.gluonhq.charm.glisten.control.Avatar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

import static nl.betabit.betabit.Data.*;
import static nl.betabit.betabit.Session.ecoPoints;
import static nl.betabit.betabit.Session.mail1;

public class main {
    private final StringChecker stringChecker = new StringChecker();

    @FXML
    private Avatar Avatar;

    @FXML
    private Text BronzeAmount;

    @FXML
    private Text EcoPointsAnount;

    @FXML
    private Text SilverAmount;

    @FXML
    private ImageView SilverIcon;

    @FXML
    private TableColumn<?, ?> TablePointsName;

    @FXML
    private TableColumn<?, ?> TableRewardName;

    @FXML
    private TextField adminAddUserMail;

    @FXML
    private TextField adminAddUserName;

    @FXML
    private PasswordField adminAddUserPasswordOne;

    @FXML
    private PasswordField adminAddUserPasswordTwo;

    @FXML
    private TextField adminAddUserPositie;

    @FXML
    private ImageView bronzeIcon;

    @FXML
    private Button buyItem;

    @FXML
    private TextField editMail;

    @FXML
    private TextField editName;

    @FXML
    private TextField editPosition;

    @FXML
    private Text fullName;

    @FXML
    private Text goldAmount;

    @FXML
    private ImageView goldIcon;

    @FXML
    private TableColumn<?, ?> leaderboardBronze;

    @FXML
    private TableView<UserData> leaderboardContainer;

    @FXML
    private TableView<RewardLog> leaderboardContainer1;

    @FXML
    private TableView<distanceLog> leaderboardContainer11;

    @FXML
    private TableColumn<?, ?> leaderboardGold;

    @FXML
    private TableColumn<?, ?> leaderboardName;

    @FXML
    private TableColumn<?, ?> leaderboardPoints;

    @FXML
    private TableColumn<?, ?> leaderboardPreference;

    @FXML
    private TableColumn<?, ?> leaderboardRank;

    @FXML
    private TableColumn<?, ?> leaderboardRank1;

    @FXML
    private TableColumn<?, ?> leaderboardRank11;

    @FXML
    private TableColumn<?, ?> leaderboardSilver;


    @FXML
    private AnchorPane leftPane;

    @FXML
    private Button logKmButton;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField oldPassword;

    @FXML
    private Text pointAmount;

    @FXML
    private Text position;

    @FXML
    private AnchorPane ranking;

    @FXML
    private TextField removeUser;

    @FXML
    private TextArea removeUserInfo;

    @FXML
    private AnchorPane rightPane;

    @FXML
    private AnchorPane root;

    @FXML
    private Button signOut;

    @FXML
    private TableColumn<?, ?> tablePointsAdded;
    @FXML
    private TableColumn<?, ?> tablePointsTravelMethod;
    @FXML
    private TableColumn<?, ?> tableNewTotalPoints;
    @FXML
    private TableColumn<?, ?> tablePointsTravelDistance;

    @FXML
    private TableColumn<?, ?> tableRewardName;

    @FXML
    private TableColumn<?, ?> tablePointsDate;

    @FXML
    private TableColumn<?, ?> tableRewardClaimed;

    @FXML
    private TableColumn<?, ?> tableRewardDate;

    @FXML
    private TableColumn<?, ?> tableRewardPayment;

    @FXML
    private Button updatePicture;

    @FXML
    private TextField logKm;

    @FXML
    private TextField logVehicle;

    @FXML
    private Button updateProfile;

    @FXML
    void AdminRemoveUser(ActionEvent event) {

        for (int i = 0; i < Data.user.size() ; i++) {
            user.removeIf(user -> user.getMail().equals(removeUser.getText()));
            userData.removeIf(userData -> userData.getMail().equals(removeUser.getText()));
        }
    }



    @FXML
    void adminAddUser(ActionEvent event) {
        String username = adminAddUserMail.getText();
        String fullname1 = adminAddUserName.getText();
        String password1 = adminAddUserPasswordOne.getText();
        String password2 = adminAddUserPasswordTwo.getText();
        String position1 = adminAddUserPositie.getText();

        if (stringChecker.isFullName(fullname1)) {
            if (password1.equals(password2)) {
                if (!stringChecker.alreadyRegistered(username) && stringChecker.isValid(username)) {
                    Data.addUser(new User(username, fullname1, position1, password1));
                    Data.addUserData(new UserData(0, 0, 0, username, 0));
                }
            }
        }
    }


    @FXML
    void removeUserLookup(ActionEvent event) {

    }

    @FXML
    void SignOut(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        root.getChildren().setAll(pane);

    }

    @FXML
    void UpdatePicture(ActionEvent event) {

    }

    @FXML
    void buyShop1(ActionEvent event) {
        String item1 = "Blijdorp";
        int kosten1 = 2000;

        if(ecoPoints >= kosten1){
            rewardLog.add(new RewardLog(StringChecker.getDate(),item1,kosten1, mail1));
            for (int i = 0; i < Data.userData.size() ; i++) {
                if (mail1.equals(userData.get(i).getMail())) {
                    ecoPoints = ecoPoints - kosten1;
                    initialize();
                    break;
                }
            }
            initialize();
        }
    }

    @FXML
    void changePassword(ActionEvent event) {

        if(Data.user.removeIf(user -> user.getPassword().equals(oldPassword))){
           // Data.user.add(new User())
        }

    }

    @FXML
    void logKm(ActionEvent event) {
        String method = logVehicle.getText();
        int pointsToAdd = 0;
        int b = Integer.parseInt(logKm.getText());
        if(method.equals("Lopen")){
            pointsToAdd = (b * 5);
            log.add(new distanceLog(StringChecker.getDate(), mail1,method,b, ecoPoints +pointsToAdd,pointsToAdd));
            ecoPoints += pointsToAdd;
            initialize();
        }
        if(method.equals("Bus")){
            pointsToAdd = (b * 3);
            log.add(new distanceLog(StringChecker.getDate(), mail1,method,b, ecoPoints +pointsToAdd,pointsToAdd));
            ecoPoints += pointsToAdd;
            initialize();
        }
        if(method.equals("Fiets")){
            pointsToAdd = (b * 4);
            ecoPoints += pointsToAdd;
            log.add(new distanceLog(StringChecker.getDate(), mail1,method,b, ecoPoints +pointsToAdd,pointsToAdd));
            initialize();
        }
        if(method.equals("E auto")){
            pointsToAdd = (2 * 3);
            log.add(new distanceLog(StringChecker.getDate(), mail1,method,b, ecoPoints +pointsToAdd,pointsToAdd));
            ecoPoints += pointsToAdd;
            initialize();
        }
        if(method.equals("Auto")){
            pointsToAdd = (1 * 3);
            log.add(new distanceLog(StringChecker.getDate(), mail1,method,b, ecoPoints +pointsToAdd,pointsToAdd));
            ecoPoints += pointsToAdd;
            initialize();
        }
        if(method.equals("Trein")){
            pointsToAdd = (2 * 3);
            log.add(new distanceLog(StringChecker.getDate(), mail1,method,b, ecoPoints +pointsToAdd,pointsToAdd));
            ecoPoints += pointsToAdd;
            initialize();
        }
    }
    @FXML
    void updateProfile(ActionEvent event) {
        int i;
        for (i = 0; i < Data.user.size() ; i++) {
            System.out.println(Session.fullname);
            System.out.println(user.get(i).getFullname());
            if (user.get(i).getFullname().equals(Session.fullname)) {
                System.out.println(Session.fullname);
                System.out.println(user.get(i).getFullname());
                System.out.println(editMail);
                System.out.println(String.valueOf(editMail));
                if (!StringChecker.alreadyRegistered(String.valueOf(editMail)) && StringChecker.isValid(String.valueOf(editMail))) {
                    user.get(i).setMail(String.valueOf(editMail));
                    String test = editMail.getText();
                    user.get(i).setMail(test);
                    initialize();

                }
            }
//        if(Data.user.removeIf(user -> user.getPassword().equals(oldPassword)))
//        //if (stringChecker.isFullName(String.valueOf(editName))) {
//        String test = String.valueOf(editMail);
//        System.out.println(String.valueOf(test));
//
//            for (User user : Data.getUser()) {
//                if (mail.equals(user.getMail())) {
//                    user.setMail(test);
//
//                }
//                        user.us
//                        Data.getUser().set(0,mail1);
//                        Data.getUser().set(0,(String.valueOf(editMail))
//                        user.setFullname(String.valueOf(fullName))
//                        user.setMail(String.valueOf(editMail))
//                        user.setPosition(String.valueOf(editPosition))
        }

    }
    public void initialize() {
        position.setText(String.valueOf(Session.position));
        fullName.setText(String.valueOf(Session.fullname));
        EcoPointsAnount.setText(String.valueOf(ecoPoints));
        BronzeAmount.setText(String.valueOf(Session.bronze));
        SilverAmount.setText(String.valueOf(Session.silver));
        goldAmount.setText(String.valueOf(Session.gold));

        tableRewardPayment.setCellValueFactory(new PropertyValueFactory<>("Payment"));
        tableRewardDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tableRewardName.setCellValueFactory(new PropertyValueFactory<>("Mail"));
        tableRewardClaimed.setCellValueFactory(new PropertyValueFactory<>("Claimed"));

        tablePointsAdded.setCellValueFactory(new PropertyValueFactory<>("addedPoints"));
        tablePointsDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tablePointsTravelMethod.setCellValueFactory(new PropertyValueFactory<>("method"));
        tableNewTotalPoints.setCellValueFactory(new PropertyValueFactory<>("newTotalPoints"));
        tablePointsTravelDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        TablePointsName.setCellValueFactory(new PropertyValueFactory<>("mail"));

        leaderboardGold.setCellValueFactory(new PropertyValueFactory<>("Gold"));
        leaderboardSilver.setCellValueFactory(new PropertyValueFactory<>("Silver"));
        leaderboardBronze.setCellValueFactory(new PropertyValueFactory<>("Bronze"));
        leaderboardPoints.setCellValueFactory(new PropertyValueFactory<>("ecoPoints"));
        leaderboardName.setCellValueFactory(new PropertyValueFactory<>("mail"));

        leaderboardContainer.setItems(getUserData());
        leaderboardContainer1.setItems(getRewardData());
        leaderboardContainer11.setItems(getLogData());
        // TODO : Load data into tableview
    }

    private ObservableList<UserData> getUserData() {
        ObservableList<UserData> userData = FXCollections.observableArrayList();
        userData.addAll(Data.getUserData());
        return userData;
    }
    private ObservableList<RewardLog> getRewardData() {
        ObservableList<RewardLog> rewardLog = FXCollections.observableArrayList();
        rewardLog.addAll(Data.getRewardLog());
        return rewardLog;
    }
    private ObservableList<distanceLog> getLogData() {
        ObservableList<distanceLog> distanceLog = FXCollections.observableArrayList();
        distanceLog.addAll(Data.getLog());
        return distanceLog;
    }
}
