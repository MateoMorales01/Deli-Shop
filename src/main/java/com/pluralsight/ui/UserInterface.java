package com.pluralsight.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public int homeScreen() {
        System.out.println("=================================================");
        System.out.println("            Welcome to The Provisions Lab                 ");
        System.out.println("=================================================");
        System.out.println("1) Start a new order");
        System.out.println("0) Exit Application");
        System.out.print("Please Enter your choice: ");

        String input = scanner.nextLine().trim();

        switch (input) {
            case "1":
                return 1;
            case "0":
                return 0;
            default:
                System.out.println("Invalid Option");
                return -1;
        }
    }

    public int orderMenu() {
        System.out.println("=================================================");
        System.out.println("---Order Menu---");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Please enter your Choice: ");
        System.out.println("\n=================================================");

        String orderMenuChoice = scanner.nextLine().trim();

        switch (orderMenuChoice) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "0":
                return 0;
            default:
                System.out.println("Invalid Option");
                return -1;
        }
    }

    public String breadType() {
        System.out.println("=================================================");
        System.out.println("Please choose bread type:");
        System.out.println("white, wheat, rye, wrap");
        System.out.print("Enter bread type: ");
        System.out.println("\n=================================================");
        return scanner.nextLine().toLowerCase().trim();
    }

    public String promptForSize() {

        System.out.println("=================================================");
        System.out.println("Please choose a size:");
        System.out.println("4\", 8\", 12\"");
        System.out.print("Enter size: ");
        System.out.println("\n=================================================");
        return scanner.nextLine().trim();
    }

    public boolean promptForToasted() {
        System.out.println("=================================================");
        System.out.print("Toasted? (yes or no): ");
        System.out.println("\n=================================================");
        String choice = scanner.nextLine().toLowerCase().trim();

        switch (choice) {
            case "yes":
            case "y":
                return true;
            case "no":
            case "n":
            default:
                return false;
        }
    }

    public List<String> promptForMeats() {
        List<String> meats = new ArrayList<>();

        System.out.println("=================================================");
        System.out.println("Add meats (Type 'done' to finish): ");
        System.out.println("steak, ham, salami, roast beef, chicken, bacon");
        System.out.println("=================================================");

        while (true) {
            System.out.print("Enter meat: ");
            String choice = scanner.nextLine().toLowerCase().trim();

            if (choice.equals("done")) {
                return meats;
            } else if (!choice.isEmpty()) {
                meats.add(choice);
            }
        }
    }

    public boolean promptForExtraMeat() {
        System.out.println("=================================================");
        System.out.print("Would you like extra meat? (yes/no): ");
        System.out.println("\n=================================================");
        String choice = scanner.nextLine().toLowerCase().trim();

        switch (choice) {
            case "yes":
            case "y":
                return true;
            case "no":
            case "n":
            default:
                return false;
        }
    }

    public List<String> promptForCheeses() {
        List<String> cheeses = new ArrayList<>();
        System.out.println("=================================================");
        System.out.println("Add cheese (type 'done' when finished):");
        System.out.println("american, provolone, cheddar, swiss");
        System.out.println("=================================================");

        while (true) {
            System.out.print("Enter cheese: ");
            String choice = scanner.nextLine().toLowerCase().trim();

            if (choice.equals("done")) {
                return cheeses;
            } else if (!choice.isEmpty()) {
                cheeses.add(choice);
            }
        }
    }

    public boolean promptForExtraCheese() {
        System.out.println("=================================================");
        System.out.print("Would you like extra cheese? (yes/no): ");
        System.out.println("\n=================================================");
        String choice = scanner.nextLine().toLowerCase().trim();

        switch (choice) {
            case "yes":
            case "y":
                return true;
            case "no":
            case "n":
            default:
                return false;
        }
    }

    public List<String> promptForRegularToppings() {
        List<String> toppings = new ArrayList<>();
        System.out.println("============================================================================================");
        System.out.println("Add regular toppings (type 'done' when finished):");
        System.out.println("lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms");
        System.out.println("============================================================================================");

        while (true) {
            System.out.print("Enter topping: ");
            String choice = scanner.nextLine().toLowerCase().trim();

            if (choice.equals("done")) {
                return toppings;
            } else if (!choice.isEmpty()) {
                toppings.add(choice);
            }
        }
    }

    public List<String> promptForSauces() {
        List<String> sauces = new ArrayList<>();
        System.out.println("===========================================================================");
        System.out.println("Add sauces (type 'done' when finished):");
        System.out.println("mayo, mustard, ketchup, ranch, thousand islands, vinaigrette, au jus");
        System.out.println("============================================================================");

        while (true) {
            System.out.print("Enter sauce: ");
            String choice = scanner.nextLine().toLowerCase().trim();

            if (choice.equals("done")) {
                return sauces;
            } else if (!choice.isEmpty()) {
                sauces.add(choice);
            }
        }
    }

    public boolean extraSauce() {
        System.out.println("=================================================");
        System.out.println("Did you want Extra cheese? (yes/no): ");
        System.out.println("\n=================================================");

        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "yes":
                return true;
            case "no":
            default:
                return false;
        }
    }

    public String promptForDrinkSize() {
        System.out.println("=================================================");
        System.out.println("Drink sizes: small, medium, large, xlarge");
        System.out.print("Please enter drink size: ");
        System.out.println("\n=================================================");
        return scanner.nextLine().toLowerCase().trim();
    }

    public String promptForDrinkFlavor() {
        System.out.println("=================================================");
        System.out.println("We are a Pepsi only company");
        System.out.print("Enter pepsi product: ");
        System.out.println("\n=================================================");
        return scanner.nextLine().toLowerCase().trim();
    }

    public String promptForChipsType() {
        System.out.println("================================================================================================");
        System.out.println("Available chips:  hot cheetos, doritos, lays original, lays jalapeno, cool ranch doritos");
        System.out.print("Enter chips type: ");
        System.out.println("\n================================================================================================");
        return scanner.nextLine().toLowerCase().trim();
    }
}
