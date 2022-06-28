package nl.betabit.betabit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Data.userData.clear();
        Data.user.clear();
        Data.user.add(new User("rowin@hhs.nl","Ester versteeg","Marketing","test"));
        Data.userData.add(new UserData(0,0,0,"rowin@hhs.nl",2020));
        Data.rewardLog.add(new RewardLog("2022-06-23","Kaartjes Blijdorp",2000,"rowin@hhs.nl"));
        Data.log.add(new distanceLog("2022-06-24","rowin@hhs.nl","Lopen",5,2020,20));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
//        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }

}