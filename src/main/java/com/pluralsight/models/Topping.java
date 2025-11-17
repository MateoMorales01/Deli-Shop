package com.pluralsight.models;

public class Topping {
    private final String name;
    private final String type;
    private boolean isExtra;


    public Topping(String name, String type, boolean isExtra) {
        this.name = name.toLowerCase();
        this.type = type.toLowerCase();
        this.isExtra = isExtra;
    }

    public String getType() {
        return type;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public String toString() {
        if (isExtra){
            return  name + "(extra)";
        }
        return name;
    }
}
