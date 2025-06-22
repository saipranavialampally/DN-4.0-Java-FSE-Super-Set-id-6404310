package week1_DesignPatterns_and_Principals.Handson4_AdapterPatternExample;

// Step 1: Target interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 2: Adaptees - third-party gateways
class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("PayPal processed payment: $" + amount);
    }
}

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Stripe processed payment: $" + amount);
    }
}

// Step 3: Adapters
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway = new PayPalGateway();

    public void processPayment(double amount) {
        gateway.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway gateway = new StripeGateway();

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

// Step 4: Test
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter();
        paypal.processPayment(120.0);

        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(230.0);
    }
}
