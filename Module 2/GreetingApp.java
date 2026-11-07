import javax.swing.*;
import java.awt.*;

public class GreetingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GreetingApp::createWindow);
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Student Greeting App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField nameField = new JTextField();
        JButton greetButton = new JButton("Greet Student");
        JLabel resultLabel = new JLabel("Enter your name above.");

        greetButton.addActionListener(event -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                resultLabel.setText("Please enter your name.");
            } else {
                resultLabel.setText("Welcome, " + name + "!");
            }
        });

        panel.add(nameField);
        panel.add(greetButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setSize(420, 220);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
