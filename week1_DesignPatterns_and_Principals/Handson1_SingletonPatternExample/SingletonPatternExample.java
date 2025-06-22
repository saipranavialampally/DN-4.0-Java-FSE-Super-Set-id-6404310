package week1_DesignPatterns_and_Principals.Handson1_SingletonPatternExample;

// Logger.java - Singleton Class
class Logger {
    private static Logger loggerInstance;

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger(); // lazy initialization
        }
        return loggerInstance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// LoggerTest.java - Test Class
public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger loggerA = Logger.getInstance();
        loggerA.log("First log from A.");

        Logger loggerB = Logger.getInstance();
        loggerB.log("Second log from B.");

        if (loggerA == loggerB) {
            System.out.println("Verified: Only one Logger instance exists.");
        } else {
            System.out.println("Error: Multiple instances exist!");
        }
    }
}
