package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;

    public class Toppings {
        private String type; // Type of topping (e.g., "meat", "cheese", "veggie")
        private double priceFor4Inch;
        private double priceFor8Inch;
        private double priceFor12Inch;

        public Toppings(String type, double priceFor4Inch, double priceFor8Inch, double priceFor12Inch) {
            this.type = type;
            this.priceFor4Inch = priceFor4Inch;
            this.priceFor8Inch = priceFor8Inch;
            this.priceFor12Inch = priceFor12Inch;
        }

        public String getType() {
            return type;
        }

        public double getPrice(String size) {
            return switch (size) {
                case "4 inch" -> 5.50;
                case "8 inch" -> 7.00;
                case "12 inch" -> 8.50;
                default -> 5.00;
            };
        }
        public double getExtraPrice(String size) {
            if (type.equals("extraMeat")) {
                switch (size) {
                    case "4 inch":
                        return 0.50;
                    case "8 inch":
                        return 1.00;
                    case "12 inch":
                        return 1.50;
                }
            } else if (type.equals("extraCheese")) {
                switch (size) {
                    case "4 inch":
                        return 0.30;
                    case "8 inch":
                        return 0.60;
                    case "12 inch":
                        return 0.90;
                }
            }
            return 0;
        }
        public void add(Toppings selectedToppings) {
        }
        // Static method to create lists of available toppings
        public static List<Toppings> getAvailableToppings() {
            List<Toppings> toppings = new ArrayList<>();

            // Meat toppings
            toppings.add(new Toppings("Turkey", 1.00, 2.00, 3.00));
            toppings.add(new Toppings("Ham", 1.00, 2.00, 3.00));
            toppings.add(new Toppings("Roast Beef", 1.00, 2.00, 3.00));
            toppings.add(new Toppings("Salami", 1.00, 2.00, 3.00));


            // Cheese toppings
            toppings.add(new Toppings("Cheddar", 0.75, 1.50, 2.25));
            toppings.add(new Toppings("Swiss", 0.75, 1.50, 2.25));
            toppings.add(new Toppings("American", 0.75, 1.50, 2.25));
            toppings.add(new Toppings("Pepper Jack", 0.75, 1.50, 2.25));

            // Vegetable toppings (free)
            toppings.add(new Toppings("Lettuce", 0.00, 0.00, 0.00));
            toppings.add(new Toppings("Tomatoes", 0.00, 0.00, 0.00));
            toppings.add(new Toppings("Onions", 0.00, 0.00, 0.00));
            toppings.add(new Toppings("Pickles", 0.00, 0.00, 0.00));
            toppings.add(new Toppings("Peppers", 0.00, 0.00, 0.00));

            // Extra toppings
            toppings.add(new Toppings("extraMeat", 0.05, 0.05, 0.05));
            toppings.add(new Toppings("extraCheese", 0.30, 0.60, 0.90));

            return toppings;
        }



    }


