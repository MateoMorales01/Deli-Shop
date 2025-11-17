package com.pluralsight.models;

import java.util.List;
import java.util.ArrayList;

public class Sandwich extends MenuItem {
    private List<Topping> toppings;
    private String bread;
    private String size;
    private boolean toasted;

    public Sandwich(String bread, String size, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
        this.toppings = new ArrayList<>(); // Initialize the list!
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        double price = 0;

        switch (size) {
            case "4":
                price += 5.50;
                break;
            case "8":
                price += 7.00;
                break;
            case "12":
                price += 8.50;
                break;
        }

        for (Topping topping : toppings) {
            String type = topping.getType();

            if (type.equals("meat")) {
                if (size.equals("4")) {
                    price += 1.00;
                } else if (size.equals("8")) {
                    price += 2.00;
                } else if (size.equals("12")) {
                    price += 3.00;
                }

                if (topping.isExtra()) {
                    if (size.equals("4")) {
                        price += 0.50;
                    } else if (size.equals("8")) {
                        price += 1.00;
                    } else if (size.equals("12")) {
                        price += 1.50;
                    }
                }
            }

            else if (type.equals("cheese")) {
                if (size.equals("4")) {
                    price += 0.75;
                } else if (size.equals("8")) {
                    price += 1.50;
                } else if (size.equals("12")) {
                    price += 2.25;
                }

                if (topping.isExtra()) {
                    if (size.equals("4")) {
                        price += 0.30;
                    } else if (size.equals("8")) {
                        price += 0.60;
                    } else if (size.equals("12")) {
                        price += 0.90;
                    }
                }
            }

        }

        return price;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(size).append("\" ").append(bread);
        if (toasted) {
            output.append(" (toasted)");
        }
        output.append("\n");

        for (Topping t : toppings) {
            output.append("  - ").append(t.toString()).append("\n");
        }

        output.append("Total: $").append(String.format("%.2f", getPrice()));

        return output.toString();
    }
}
