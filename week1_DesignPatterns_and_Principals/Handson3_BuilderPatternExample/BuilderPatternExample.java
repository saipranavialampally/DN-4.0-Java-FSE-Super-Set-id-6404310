package week1_DesignPatterns_and_Principals.Handson3_BuilderPatternExample;

//  Product class with private constructor
class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private boolean hasGraphicsCard;
    private boolean hasBluetooth;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    public void showConfig() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + (hasGraphicsCard ? "Yes" : "No"));
        System.out.println("Bluetooth: " + (hasBluetooth ? "Yes" : "No"));
        System.out.println();
    }

    // Static Nested Builder Class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean value) {
            this.hasGraphicsCard = value;
            return this;
        }

        public Builder setBluetooth(boolean value) {
            this.hasBluetooth = value;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

// Test Class
public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer basicPC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("4GB")
                .setStorage("256GB SSD")
                .build();

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB NVMe")
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();

        basicPC.showConfig();
        gamingPC.showConfig();
    }
}
