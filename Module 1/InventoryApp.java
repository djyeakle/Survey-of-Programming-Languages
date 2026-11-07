import javax.swing.JOptionPane;

public class InventoryApp {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 899.99, 5);
        Product product2 = new Product("Monitor", 59.99, 9);

        System.out.println("Product 1: " + product1.getName());
        System.out.println("Product 1 Value: " + product1.calculateInventoryValue());

        System.out.println("Product 2: " + product2.getName());
        System.out.println("Product 2 Value: " + product2.calculateInventoryValue());

        double total = product1.calculateInventoryValue() + product2.calculateInventoryValue();

        JOptionPane.showMessageDialog(null, "Total Inventory Value: $" + String.format("%.2f", total));
    }
}
