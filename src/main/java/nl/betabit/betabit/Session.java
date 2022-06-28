package nl.betabit.betabit;

public class Session {

    static Integer gold;
    static Integer silver;
    static Integer bronze;
    static String fullname;
    static String position;
    static Integer ecoPoints;
    static String mail1;

    static void createSession(String mail){
        mail1 = mail;
        for(User user : Data.getUser()){
            if(mail.equals(user.getMail())){
                fullname = user.getFullname();
                position = user.getPosition();
            }
        }
        for(UserData userData : Data.getUserData()){
            if(mail.equals(userData.getMail())){
                gold = userData.getGold();
                silver = userData.getSilver();
                bronze = userData.getBronze();
                ecoPoints = userData.getEcoPoints();
                System.out.println(ecoPoints);
            }
        }

    }
}
