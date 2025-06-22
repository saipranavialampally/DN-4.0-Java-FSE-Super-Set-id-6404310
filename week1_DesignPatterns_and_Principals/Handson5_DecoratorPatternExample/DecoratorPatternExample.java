package week1_DesignPatterns_and_Principals.Handson5_DecoratorPatternExample;

// Step 1: Component interface
interface Notifier {
    void send(String message);
}

// Step 2: Concrete component
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sent Email: " + message);
    }
}

// Step 3: Abstract decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

// Step 4: Concrete decorators
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("SMS sent: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Slack message sent: " + message);
    }
}

// Step 5: Test
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier baseNotifier = new EmailNotifier();
        Notifier multiChannelNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(baseNotifier));

        multiChannelNotifier.send("System down alert!!!");
    }
}
