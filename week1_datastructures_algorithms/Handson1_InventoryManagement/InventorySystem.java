package week1_datastructures_algorithms.Handson1_InventoryManagement;

import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    Map<Integer, Product> inventory = new HashMap<>();

    void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    void updateProduct(int productId, int quantity, double price) {
        Product p = inventory.get(productId);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
        }
    }

    void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p.productId + " " + p.productName + " " + p.quantity + " $" + p.price);
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(101, "Laptop", 5, 75000));
        inv.addProduct(new Product(102, "Mouse", 11, 700));
        inv.displayInventory();

        inv.updateProduct(101, 9, 54000);
        inv.deleteProduct(102);
        System.out.println("After update and delete:");
        inv.displayInventory();
    }
}
