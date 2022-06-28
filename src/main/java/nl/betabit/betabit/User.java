package nl.betabit.betabit;

public class User extends Data {

    private  String mail;
    private  String fullname;
    private  String position;
    private  String password;


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public  String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String mail, String fullname, String position, String password) {
        this.mail = mail;
        this.fullname = fullname;
        this.position = position;
        this.password = password;
    }
}
