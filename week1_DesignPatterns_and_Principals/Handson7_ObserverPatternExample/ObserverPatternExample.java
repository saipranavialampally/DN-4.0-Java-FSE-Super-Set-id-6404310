package week1_DesignPatterns_and_Principals.Handson7_ObserverPatternExample;

import java.util.*;

// Step 1: Observer Interface
interface Observer {
    void update(String stock, double price);
}

// Step 2: Subject Interface
interface Stock {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// Step 3: Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStockData(String name, double price) {
        this.stockName = name;
        this.stockPrice = price;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

// Step 4: Concrete Observers
class MobileApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("MobileApp: " + stock + " updated to Rs." + price);
    }
}

class WebApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("WebApp: " + stock + " updated to Rs." + price);
    }
}

// Step 5: Test Class
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStockData("TCS", 3660.40);
        stockMarket.setStockData("INF", 1633.75);
    }
}
