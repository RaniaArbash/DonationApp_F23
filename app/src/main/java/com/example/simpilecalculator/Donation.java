package com.example.simpilecalculator;

import java.util.Date;

public class Donation {

    int payment_method;
    double amount;
    Date donation_date;

    public Donation(int payment_method, double amount, Date donation_date) {
        this.payment_method = payment_method;
        this.amount = amount;
        this.donation_date = donation_date;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "payment_method=" + payment_method +
                ", amount=" + amount +
                ", donation_date=" + donation_date +
                '}';
    }
}
