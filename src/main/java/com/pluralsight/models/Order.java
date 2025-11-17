package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<MenuItem> menuItems = new ArrayList<>();

    public List<MenuItem> getItems(){
        return menuItems;
    }

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public double getTotal() {
        return menuItems.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        String output = "";

        output += "===== ORDER #" + orderNumber + " =====\n\n";

        for (MenuItem item : menuItems) {
            output += item.toString() + "\n\n";
        }

        output += "-------------------------\n";
        output += "ORDER TOTAL: $" + String.format("%.2f", getTotal()) + "\n";
        output += "=========================\n";

        return output;
    }
}
