package com.pluralsight.models;

public class Chips extends MenuItem {

    private String bagOfChips;

    public Chips(String bagOfChips) {
        this.bagOfChips = bagOfChips;
    }

    public String getBagOfChips() {
        return bagOfChips;
    }

    public void setBagOfChips(String bagOfChips) {
        this.bagOfChips = bagOfChips;
    }

    @Override
    public double getPrice() {
        return 1.5;
    }

    public String toString() {
        return bagOfChips.substring(0, 1).toUpperCase() + bagOfChips.substring(1) + " - $1.50";
    }
}

