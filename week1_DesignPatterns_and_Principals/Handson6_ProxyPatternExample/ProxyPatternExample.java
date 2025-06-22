package week1_DesignPatterns_and_Principals.Handson6_ProxyPatternExample;

// Subject interface
interface Image {
    void display();
}

// Real subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from server: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Step 3: Proxy class
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Lazy init
        } else {
            System.out.println("Using cached image: " + filename);
        }
        realImage.display();
    }
}

// Step 4: Test
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("nature.jpg");

        // First time: loads from server
        img1.display();

        // Second time: uses cache
        img1.display();
    }
}
