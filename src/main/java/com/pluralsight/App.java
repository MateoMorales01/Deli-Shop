package com.pluralsight;

import com.pluralsight.data.ReceiptManager;
import com.pluralsight.models.*;
import com.pluralsight.ui.UserInterface;

public class App {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        boolean running = true;

        while (running) {

            int homeChoice = ui.homeScreen();

            switch (String.valueOf(homeChoice)) {

                case "1":
                    startNewOrder(ui);
                    break;

                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    private static void startNewOrder(UserInterface ui) {

        Order order = new Order(1);
        boolean ordering = true;

        while (ordering) {

            int orderChoice = ui.orderMenu();

            switch (String.valueOf(orderChoice)) {

                case "1":
                    Sandwich sandwich = buildSandwich(ui);
                    order.addItem(sandwich);
                    System.out.println("Sandwich added!");
                    break;

                case "2":
                    Drink drink = buildDrink(ui);
                    order.addItem(drink);
                    System.out.println("Drink added!");
                    break;

                case "3":
                    Chips chips = buildChips(ui);
                    order.addItem(chips);
                    System.out.println("Chips added!");
                    break;

                case "4":
                    checkoutOrder(order);
                    ordering = false;
                    break;

                case "0":
                    System.out.println("Order cancelled.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static Sandwich buildSandwich(UserInterface ui) {

        String bread = ui.breadType();
        String size = ui.addSize();
        boolean toasted = ui.makeToasted();

        Sandwich sandwich = new Sandwich(bread, size, toasted);

        for (String meat : ui.addMeats()) {
            boolean extra = ui.addExtraMeat();
            sandwich.addTopping(new Topping(meat, "meat", extra));
        }

        for (String cheese : ui.addCheese()) {
            boolean extra = ui.addExtraCheese();
            sandwich.addTopping(new Topping(cheese, "cheese", extra));
        }

        for (String topping : ui.addToppings()) {
            sandwich.addTopping(new Topping(topping, "regular", false));
        }

        for (String sauce : ui.addSauces()) {
            boolean extra = ui.addExtraSauce();
            sandwich.addTopping(new Topping(sauce, "sauce", extra));
        }

        return sandwich;
    }

    private static Drink buildDrink(UserInterface ui) {
        String size = ui.addDrinkSize();
        String flavor = ui.addDrinkFlavor();
        return new Drink(size, flavor);
    }

    private static Chips buildChips(UserInterface ui) {
        String type = ui.addChips();
        return new Chips(type);
    }

    private static void checkoutOrder(Order order) {

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println(order);

        System.out.println("\nSaving receipt...");
        ReceiptManager.saveReceipt(order);

        System.out.println("Order complete! Thank you for choosing Provisions Lab!\n");
    }
}

