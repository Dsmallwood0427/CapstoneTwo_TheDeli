package com.ps;

import com.ps.CustomClasses.BagOfChips;
import com.ps.CustomClasses.Drink;
import com.ps.CustomClasses.Order;
import com.ps.CustomClasses.Sandwich;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order currentOrder;

    public UserInterface() {
        scanner = new Scanner(System.in);
        currentOrder = new Order();
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("Welcome to the Deli!");
            System.out.println("1. New Order");
            System.out.println("2. Exit");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                showOrderMenu();
            } else {
                break; // Exit the program
            }
        }
    }

    private void showOrderMenu() {
        while (true) {
            System.out.println("Order Menu:");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("5. Go Back");
            System.out.println("6. Cancel Order");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkout();
                    return; // Return to main menu after checkout
                case "5":
                    return; // Go back to main menu
                case "6":
                    currentOrder = new Order(); // Reset order
                    System.out.println("Order cancelled.");
                    return;
            }
        }
    }


    private void addSandwich() {
        System.out.println("Select Bread: (1) White, (2) Wheat, (3) Rye, (4)Wrap");
        String bread = switch (scanner.nextLine()) {
            case "1" -> "White";
            case "2" -> "Wheat";
            case "3" -> "Rye";
            case "4" -> "Wrap";
            default -> "Salad";
        };

        System.out.println("Select Size: (1) 4 inch, (2) 8 inch, (3) 12 inch");
        String size = switch (scanner.nextLine()) {
            case "1" -> "4 inch";
            case "2" -> "8 inch";
            case "3" -> "12 inch";
            default -> "4 inch"; // Default
        };

        System.out.println("Would you like your sandwich toasted? (yes/no)");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(bread, size, toasted);
        addToppings(sandwich);
        currentOrder.addProduct(sandwich);
        System.out.println("Sandwich added: " + sandwich);
    }

    private void addToppings(Sandwich sandwich) {
        System.out.println("Add Topping: (1) Meat, (2) Cheese, (3) Veggies, (4) Sauces (5) Extra Toppings");
        String toppingChoice = scanner.nextLine();
        switch (toppingChoice) {
            case "1":
                sandwich.addTopping("meat");
                break;
            case "2":
                sandwich.addTopping("cheese");
                break;
            case "3":
                sandwich.addTopping("veggies");
                break;
            case "4":
                sandwich.addTopping("sauces");
                break;

            case "5":
                sandwich.addTopping("extraTopping");
                break;
        }
    }

    private void addDrink() {
        System.out.println("Select Drink Size: (1) Small, (2) Medium, (3) Large");
        String size = switch (scanner.nextLine()) {
            case "1" -> "Small";
            case "2" -> "Medium";
            case "3" -> "Large";
            default -> "You're in the default";
        };
        Drink drink = new Drink(size);
        currentOrder.addProduct(drink);
        System.out.println("Drink added: " + drink);
    }

    private void addChips() {
        BagOfChips chips = new BagOfChips();
        currentOrder.addProduct(chips);
        System.out.println("Chips added: " + chips);
    }

    private void checkout() {
        System.out.println(currentOrder);
        System.out.println("Would you like to confirm your order? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            System.out.println("Thank you for your order!");
        } else {
            currentOrder = new Order(); // Reset order
            System.out.println("Order cancelled.");
        }
    }
}








