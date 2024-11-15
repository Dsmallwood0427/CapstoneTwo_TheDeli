package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order Details:\n");
        for (Product product : products) {
            orderDetails.append(product.toString()).append("\n");
        }
        orderDetails.append("Total Price: $").append(getTotalPrice());
        return orderDetails.toString();
    }
}






