package week1_datastructures_algorithms.Handson2_Ecommercesearch;

import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }
}

public class SearchSystem {

    static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id)
                return p;
        }
        return null;
    }

    static Product binarySearch(Product[] products, int id) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == id)
                return products[mid];
            else if (products[mid].productId < id)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "MobilePhone", "Electronics"),
                new Product(102, "Shirt", "Clothing"),
                new Product(103, "Pen", "Stationery")
        };

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId)); // Required for binary search

        Product found = linearSearch(products, 102);
        System.out.println("Linear Search Result: " + (found != null ? found.productName : "Not Found"));

        found = binarySearch(products, 103);
        System.out.println("Binary Search Result: " + (found != null ? found.productName : "Not Found"));
    }
}
