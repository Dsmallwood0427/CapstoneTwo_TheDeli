package com.ps;

import com.ps.CustomClasses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static jdk.internal.jrtfs.JrtFileAttributeView.AttrID.size;

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
            default -> "White";

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
        List<Toppings> availableToppings = Toppings.getAvailableToppings();
        List<Toppings> selectedToppings = new ArrayList<>();

        System.out.println("Select Toppings:");
        System.out.println("Meats:");
        int index = 1;
        for (Toppings toppings : availableToppings) {
            if (toppings.getType().equals("Turkey") || toppings.getType().equals("Ham") ||
                    toppings.getType().equals("Roast Beef") || toppings.getType().equals("Salami")) {
                System.out.println(index + ". " + toppings.getType() + " - $" + toppings.getPrice(size));
                index++;
            }
        }

        System.out.println("Cheeses:");
        for (Toppings topping : availableToppings) {
            if (topping.getType().equals("Cheddar") || topping.getType().equals("Swiss") ||
                    topping.getType().equals("American") || topping.getType().equals("Pepper Jack")) {
                System.out.println(index + ". " + topping.getType() + " - $" + topping.getPrice(size));
                index++;
            }
        }

        System.out.println("Vegetables (Free):");
        for (Toppings topping : availableToppings) {
            if (topping.getPrice(size) == 0) {
                System.out.println(index + ". " + topping.getType());
                index++;
            }
        }

        System.out.println("Select toppings by number (type 'done' when finished):");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            int toppingIndex = Integer.parseInt(input) - 1; // Convert to zero-based index
            if (toppingIndex >= 0 && toppingIndex < availableToppings.size()) {
                Toppings selectedToppings = availableToppings.get(toppingIndex);
                selectedToppings.add(selectedToppings);
                sandwich.addTopping(selectedToppings);
                System.out.println("Added: " + selectedToppings.getType());
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
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








