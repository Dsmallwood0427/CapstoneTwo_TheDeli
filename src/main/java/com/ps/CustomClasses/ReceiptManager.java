package com.ps.CustomClasses;

public class ReceiptManager {
    private Order order;

    public ReceiptManager(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        System.out.println("\u001B[34m=== Receipt ===\u001B[0m");
        System.out.println("Order Details:");
        System.out.printf("\u001B[31m2.Total Price: $%.2f%n\u001B[0m", order.getTotalPrice());
        System.out.println("================");
    }
}
