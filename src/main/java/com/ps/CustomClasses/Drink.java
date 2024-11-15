package com.ps.CustomClasses;

public class Drink extends Product {
    private String size; // "Small", "Medium", "Large"

    public Drink(String size) {
        super("Drink");
        this.size = size;
    }
    public double getPrice() {
        switch (size) {
            case "Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", size);
    }
}


