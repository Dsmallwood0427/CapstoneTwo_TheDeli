package com.ps;

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
            System.out.println("Order Menu:");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("5. Go Back");
            System.out.println("6. Cancel Order");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    return; // Return to main menu after checkout
                case 5:
                    return; // Go back to main menu
                case 6:
                    currentOrder = new Order(); // Reset order
                    System.out.println("Order cancelled.");
                    return;
            }
        }
    }
