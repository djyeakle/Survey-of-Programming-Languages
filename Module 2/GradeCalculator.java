import javax.swing.*;
import java.awt.*;

public class GradeCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Frame to hold the components
            JFrame frame = new JFrame("Grade Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Panel to go in the frame
            JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Tells user what to enter
            JLabel instructionLabel = new JLabel("Enter your grades below (0-100):");

            // Text fields for user input
            JTextField grade1 = new JTextField();
            JTextField grade2 = new JTextField();
            JTextField grade3 = new JTextField();

            // Button to calculate the average and the letter grade
            JButton calculate = new JButton("Calculate Grade");

            // Label to display results
            JLabel results = new JLabel("Average and letter grade will appear here.");

            // Action listener for the button
            calculate.addActionListener(event -> {
                if (grade1.getText().isEmpty() || grade2.getText().isEmpty() || grade3.getText().isEmpty()) {
                    results.setText("Please enter all three grades.");
                } else {
                    try {
                        double g1 = Double.parseDouble(grade1.getText().trim());
                        double g2 = Double.parseDouble(grade2.getText().trim());
                        double g3 = Double.parseDouble(grade3.getText().trim());

                        double average = (g1 + g2 + g3) / 3;

                        String letterGrade;
                        if (average >= 90) {
                            letterGrade = "A";
                        } else if (average >= 80) {
                            letterGrade = "B";
                        } else if (average >= 70) {
                            letterGrade = "C";
                        } else if (average >= 60) {
                            letterGrade = "D";
                        } else {
                            letterGrade = "F";
                        }

                        results.setText("Average: " + average + ", Letter Grade: " + letterGrade);
                    } catch (NumberFormatException ex) {
                        results.setText("Please enter valid numeric grades.");
                    }
                }
            });

            // Set up the panel
            panel.add(instructionLabel);
            panel.add(grade1);
            panel.add(grade2);
            panel.add(grade3);
            panel.add(calculate);
            panel.add(results);

            // Set up the frame
            frame.add(panel);
            frame.setSize(420, 220);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}