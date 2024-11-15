package com.ps;

import com.ps.CustomClasses.*;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("\u001B[34mWelcome to the Deli!\u001B[0m"); // Blue text
            System.out.println("\u001B[32m1. New Order\u001B[0m"); // Green text
            System.out.println("\u001B[31m2. Exit\u001B[0m"); // Red text
            int choice = scanner.nextInt();
            if (choice == 1) {
                showOrderMenu();
            } else {
                break; // Exit the program
            }
        }
    }

    private void showOrderMenu() {
        while (true) {
            System.out.println("\u001B[33mOrder Menu:\u001B[0m");
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
            default -> "white";

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

        Sandwich Sandwich = new Sandwich(bread, size, toasted);
        addToppings(Sandwich);
        String sandwich = "";
        System.out.println("Sandwich added: " + sandwich);
    }

    private void addToppings(Sandwich sandwich) {
        List<Toppings> availableToppings = Toppings.getAvailableToppings();
        List<Toppings> selectedToppings = new ArrayList<>();


        System.out.println("Select Toppings:");
        System.out.println("Meats:");
        int index = 1;
        String size = "";
        for (Toppings topping : availableToppings) {
            if (topping.getType().equals("Turkey") || topping.getType().equals("Ham") ||
                    topping.getType().equals("Roast Beef") || topping.getType().equals("Salami")) {
                System.out.println(index + ". " + topping.getType() + " - $" + topping.getPrice(size));
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
            if (topping.getType().equals("Lettuce") || topping.getType().equals("Tomatoes") ||
                    topping.getType().equals("Pickles") || topping.getType().equals("Onions")) {
                System.out.println(index + ". " + topping.getType()+ " - $" + topping.getPrice(size));
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
                Toppings selectedTopping = availableToppings.get(toppingIndex);
                selectedToppings.add(selectedTopping);
                System.out.println("Added: " + selectedTopping.getType());
            } else {
                System.out.println("Invalid selection. Please try again.");
                String choice = scanner.nextLine();
            }
        }
        System.out.println("Would you like extra meat? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            Toppings extraMeat = availableToppings.get(availableToppings.size() - 2); // Extra meat
            sandwich.addTopping(extraMeat);
            double extraPrice = extraMeat.getExtraPrice(sandwich.getSize());
            System.out.println("Extra meat added for an additional cost of: $" + extraPrice);
        }

        // Option to add extra cheese
        System.out.println("Would you like extra cheese? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            Toppings extraCheese = availableToppings.get(availableToppings.size() - 1); // Extra cheese
            sandwich.addTopping(extraCheese);
            double extraPrice = extraCheese.getExtraPrice(sandwich.getSize());
            System.out.println("Extra cheese added for an additional cost of: $" + extraPrice);
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
        BagOfChips bagOfChips = new BagOfChips();
        currentOrder.addProduct(bagOfChips);
        System.out.println("Chips added: " + bagOfChips);
    }

    private void checkout() {
        System.out.println(currentOrder);
        System.out.println("Would you like to confirm your order? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            ReceiptManager receiptManager = new ReceiptManager(currentOrder);
            receiptManager.printReceipt(); // Print the receipt
            System.out.println("Thank you for your order!");
            currentOrder = new Order(); // Reset order after checkout
        } else {
            currentOrder = new Order(); // Reset order
            System.out.println("Order cancelled.");
        }
    }
}








