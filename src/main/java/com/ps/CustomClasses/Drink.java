package com.ps.CustomClasses;

public class Drink extends Product {
    private String size; // "Small", "Medium", "Large"

    public Drink(String size) {
        super("Drink");
        this.size = size;
    }

}
