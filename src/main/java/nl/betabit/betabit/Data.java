package nl.betabit.betabit;

import java.util.ArrayList;

public class Data {

    public static ArrayList<User> user = new ArrayList<>();

    public static ArrayList<RewardLog> getRewardLog() {
        return rewardLog;
    }

    public static void setRewardLog(ArrayList<RewardLog> rewardLog) {
        Data.rewardLog = rewardLog;
    }

    public static ArrayList<distanceLog> getLog() {
        return log;
    }

    public static void setLog(ArrayList<distanceLog> log) {
        Data.log = log;
    }

    public static ArrayList<UserData> userData = new ArrayList<>();
    public static ArrayList<RewardLog> rewardLog = new ArrayList<>();
    public static ArrayList<distanceLog> log = new ArrayList<>();

    public static ArrayList<User> getUser() {
        return user;
    }
    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    public static ArrayList<UserData> getUserData() {
        return userData;
    }

    public void setUserData(ArrayList<UserData> userData) {
        this.userData = userData;
    }

    static void addUser(User User){
        user.add(User);
    }
    static void addUserData(UserData userData44){
        userData.add(userData44);

    }


}
