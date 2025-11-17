package com.pluralsight;

import com.pluralsight.data.RecieptManager;
import com.pluralsight.models.*;
import com.pluralsight.ui.UserInterface;

public class App {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        boolean running = true;

        while (running) {

            int homeChoice = ui.homeScreen();

            switch (String.valueOf(homeChoice)) {


                // NEW ORDER

                case "1":
                    startNewOrder(ui);
                    break;


                // EXIT APP

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


                // ADD SANDWICH

                case "1":
                    Sandwich sandwich = buildSandwich(ui);
                    order.addItem(sandwich);
                    System.out.println("Sandwich added!");
                    break;


                // ADD DRINK

                case "2":
                    Drink drink = buildDrink(ui);
                    order.addItem(drink);
                    System.out.println("Drink added!");
                    break;


                // ADD CHIPS

                case "3":
                    Chips chips = buildChips(ui);
                    order.addItem(chips);
                    System.out.println("Chips added!");
                    break;


                // CHECKOUT

                case "4":
                    checkoutOrder(order);
                    ordering = false;
                    break;


                // CANCEL ORDER

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
        String size = ui.promptForSize();
        boolean toasted = ui.promptForToasted();

        Sandwich sandwich = new Sandwich(bread, size, toasted);

        // MEATS
        for (String meat : ui.promptForMeats()) {
            boolean extra = ui.promptForExtraMeat();
            sandwich.addTopping(new Topping(meat, "meat", extra));
        }

        // CHEESES
        for (String cheese : ui.promptForCheeses()) {
            boolean extra = ui.promptForExtraCheese();
            sandwich.addTopping(new Topping(cheese, "cheese", extra));
        }

        // REGULAR TOPPINGS
        for (String topping : ui.promptForRegularToppings()) {
            sandwich.addTopping(new Topping(topping, "regular", false));
        }

        // SAUCES
        for (String sauce : ui.promptForSauces()) {
            sandwich.addTopping(new Topping(sauce, "sauce", false));
        }

        return sandwich;
    }


    // BUILD DRINK

    private static Drink buildDrink(UserInterface ui) {
        String size = ui.promptForDrinkSize();
        String flavor = ui.promptForDrinkFlavor();
        return new Drink(size, flavor);
    }


    // BUILD CHIPS

    private static Chips buildChips(UserInterface ui) {
        String type = ui.promptForChipsType();
        return new Chips(type);
    }


    // CHECKOUT PROCESS

    private static void checkoutOrder(Order order) {

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println(order);

        System.out.println("\nSaving receipt...");
        RecieptManager.saveReceipt(order);

        System.out.println("Order complete! Returning to home screen.\n");
    }
}

