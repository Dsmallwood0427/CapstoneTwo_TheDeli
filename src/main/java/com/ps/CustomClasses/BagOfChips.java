package com.ps.CustomClasses;

public class BagOfChips extends Product {
    public BagOfChips() {
        super("Chips");
    }
    public double getPrice() {
        return 1.50;
    }
    @Override
    public String toString() {
        return name;
    }

}

