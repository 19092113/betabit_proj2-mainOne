package nl.betabit.betabit;

public class UserData extends Data {


    Integer gold;
    Integer silver;
    Integer bronze;
    String mail;
    static Integer ecoPoints;

    public static void setEcoPoints(Integer ecoPoints) {
        UserData.ecoPoints = ecoPoints;
    }

    public UserData(Integer gold, Integer silver, Integer bronze, String mail, Integer ecoPoints) {
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.mail = mail;
        this.ecoPoints = ecoPoints;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getBronze() {
        return bronze;
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getEcoPoints() {
        return ecoPoints;
    }

}
