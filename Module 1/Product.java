public class Product {
    private String name;
    private double price;
    private double quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateInventoryValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }
}
