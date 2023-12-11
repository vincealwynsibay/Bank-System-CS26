package com.banksystem.data;

import java.util.Calendar;

public class Loan {

    private int amount;
    private double interestRate;
    private String created_at;
    private String updated_at;

    public Loan(int amount) {
        this.amount = amount;
    }

    public Loan(int amount, double interestRate) {
        this.amount = amount;

        // same sa account
        Calendar cal = Calendar.getInstance();
        this.created_at = formatDate(cal.get(cal.MONTH)) + formatDate(cal.get(cal.DAY_OF_MONTH))
                + String.valueOf(cal.get(cal.YEAR));
        this.updated_at = formatDate(cal.get(cal.MONTH)) + formatDate(cal.get(cal.DAY_OF_MONTH))
                + String.valueOf(cal.get(cal.YEAR));
        ;
    }

    public static int getAvailableLoanAmount(String userCreated) {

        Calendar cal = Calendar.getInstance();
        int difference = 0;

        int created_year = Integer.parseInt(userCreated.substring(3));
        int created_month = Integer.parseInt(userCreated.substring(0, 2));

        // gikuha ang kung when gi himo ni nga account para makita kung hantod sa unsa
        // na amount ang pwede ma loan
        int differenceInYear = (cal.get(cal.YEAR) - created_year) * 12;
        difference = ((cal.get(cal.MONTH) + differenceInYear) - created_month) + 1;

        if (difference > 12) {
            return 100000;
        } else if (difference > 6) {
            return 50000;
        } else if (difference > 3) {
            return 25000;
        }

        return 0;

    }

    public int getAmount() {
        return amount;
    }

    // same sa account
    public int updateInterest() {
        Calendar cal = Calendar.getInstance();
        if (getDifferenceInMonths() > 1) {
            this.updated_at = formatDate(cal.get(cal.MONTH)) + formatDate(cal.DAY_OF_MONTH)
                    + String.valueOf(cal.get(cal.YEAR));
            return this.amount += (this.amount * (interestRate * getDifferenceInMonths()));
        }

        return this.amount;
    }

    // same sa account
    private String formatDate(int num) {
        if (num > 9) {
            return String.valueOf(num);
        } else {

            return "0" + String.valueOf(num);
        }
    }

    // same sa account
    protected int getDifferenceInMonths() {
        Calendar cal = Calendar.getInstance();
        int difference = 0;

        int last_updated_year = Integer.parseInt(this.updated_at.substring(3));
        int last_updated_month = Integer.parseInt(this.updated_at.substring(0, 2));

        int differenceInYear = (cal.get(cal.YEAR) - last_updated_year) * 12;
        difference = ((cal.get(cal.MONTH) + differenceInYear) - last_updated_month) + 1;

        return difference;
    }

}
