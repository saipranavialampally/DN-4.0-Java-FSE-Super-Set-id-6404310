package week1_datastructures_algorithms.Handson3_CustomerOrderSorting;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }
}

public class OrderSorting {

    static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Pranavi", 2000.0),
                new Order(2, "Tanu", 1500.0),
                new Order(3, "Anu", 3000.0)
        };

        System.out.println("Bubble Sort:");
        bubbleSort(orders);
        for (Order o : orders)
            System.out.println(o.customerName + ": " + o.totalPrice);

        orders = new Order[] {
                new Order(1, "Pranavi", 7000.0),
                new Order(2, "Tanu", 5200.0),
                new Order(3, "Anu", 5000.0)
        };

        System.out.println("\nQuick Sort:");
        quickSort(orders, 0, orders.length - 1);
        for (Order o : orders)
            System.out.println(o.customerName + ": " + o.totalPrice);
    }
}
