package week1_DesignPatterns_and_Principals.Handson8_StrategyPatternExample;

// Step 1: Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 2: Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal.");
    }
}

// Step 3: Context Class
class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(double amount) {
        if (strategy != null) {
            strategy.pay(amount);
        } else {
            System.out.println("No payment method selected.");
        }
    }
}

// Step 4: Test
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.makePayment(900.00);

        context.setPaymentStrategy(new PayPalPayment());
        context.makePayment(850.75);
    }
}
