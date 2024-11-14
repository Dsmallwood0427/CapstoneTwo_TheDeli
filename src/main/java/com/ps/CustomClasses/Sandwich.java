package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;

    public class Sandwich extends Product {
        private String bread;
        private String size; // "4 inch", "8 inch", "12 inch"
        private List<String> toppings;
        private boolean toasted;

        public Sandwich(String bread, String size, boolean toasted) {
            super("Sandwich");
            this.bread = bread;
            this.size = size;
            this.toppings = new ArrayList<>();
            this.toasted = toasted;
        }

        public void addTopping(String topping) {
            toppings.add(topping);
        }

        public double getPrice() {
            double basePrice = 0;
            switch (size) {
                case "4' inch":
                    basePrice = 5.50;
                    break;
                case "8' inch":
                    basePrice = 7.00;
                    break;
                case "12' inch":
                    basePrice = 8.50;
                    break;
            }
            return basePrice + (toppings.contains("meat") ? 1 : 0); // Example price addition for toppings
        }

        @Override
        public String toString() {
            return String.format("%s: %s, Size: %s, Toppings: %s, Toasted: %s", name, bread, size, toppings.toString(), toasted ? "Yes" : "No");
        }
    }


