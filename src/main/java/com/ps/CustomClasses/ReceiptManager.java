package com.ps.CustomClasses;

public class ReceiptManager {
    private Order order;

    public ReceiptManager(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        System.out.println("=== Receipt ===");
        System.out.println("Order Details:");
        System.out.printf("Total Price: $%.2f%n", order.getTotalPrice());
        System.out.println("================");
    }
}
