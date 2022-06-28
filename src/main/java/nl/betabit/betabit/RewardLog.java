package nl.betabit.betabit;

import javafx.scene.control.cell.PropertyValueFactory;

public class RewardLog {

    String Date;
    String Claimed;
    int Payment;
    String Mail;


    public RewardLog(String date, String claimed, int payment, String mail) {
        Date = date;
        Claimed = claimed;
        Payment = payment;
        Mail = mail;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getClaimed() {
        return Claimed;
    }

    public void setClaimed(String claimed) {
        Claimed = claimed;
    }

    public int getPayment() {
        return Payment;
    }

    public void setPayment(int payment) {
        Payment = payment;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }


}
