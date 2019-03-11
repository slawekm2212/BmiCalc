package com.example.BmiCalc;

public class UserDetails {
    private double userWeight;
    private double userHeight;
    private String userHealthCategory;
    private double userBMI;

    public UserDetails() {
    }

    public UserDetails(double userWeight, double userHeight) {
        this.userWeight = userWeight;
        this.userHeight = userHeight;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public double getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(double userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserHealthCategory() {
        return userHealthCategory;
    }

    public void setUserHealthCategory(String userHealthCategory) {
        this.userHealthCategory = userHealthCategory;
    }

    public double getUserBMI() {
        return userBMI;
    }

    public void setUserBMI(double userBMI) {
        this.userBMI = userBMI;
    }
}
