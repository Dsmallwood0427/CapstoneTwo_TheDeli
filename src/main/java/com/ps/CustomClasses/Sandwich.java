package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private final String size;
    private final List<Toppings> toppings;

    public Sandwich(String bread, String size, boolean toasted) {
        this.size = size;
        this.toppings = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {
        double price = 0;
        // Base price for the bread size
        switch (size) {
            case "4 inch":
                price += 5.50; // Base price for 4 inch bread
                break;
            case "8 inch":
                price += 7.00; // Base price for 8 inch bread
                break;
            case "12 inch":
                price += 8.50; // Base price for 12 inch bread
                break;
        }

        // Add prices for toppings
        for (Toppings topping : toppings) {
            if (topping.getType().equals("extraMeat")) {
                price += topping.getExtraPrice(size); // Add extra meat price
            } else if (topping.getType().equals("extraCheese")) {
                price += topping.getExtraPrice(size); // Add extra cheese price
            } else {
                price += topping.getPrice(size); // Add


            }
        }
        return price;
    }
}