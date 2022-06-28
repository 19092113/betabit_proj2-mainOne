package nl.betabit.betabit;

public class distanceLog {
    String date;
    String mail;
    String method;
    int distance;
    int newTotalPoints;
    int addedPoints;

    public distanceLog(String date, String mail, String method, int distance, int newTotalPoints, int addedPoints) {
        this.date = date;
        this.mail = mail;
        this.method = method;
        this.distance = distance;
        this.newTotalPoints = newTotalPoints;
        this.addedPoints = addedPoints;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNewTotalPoints() {
        return newTotalPoints;
    }

    public void setNewTotalPoints(int newTotalPoints) {
        this.newTotalPoints = newTotalPoints;
    }

    public int getAddedPoints() {
        return addedPoints;
    }

    public void setAddedPoints(int addedPoints) {
        this.addedPoints = addedPoints;
    }





}
