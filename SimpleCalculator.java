import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    // Create the main frame
    private JFrame frame;
    // Create a text field to display the numbers and results
    private JTextField textField;
    // To store the operator and operands
    private double num1, num2, result;
    private String operator;

    public SimpleCalculator() {
        // Initialize the frame
        frame = new JFrame("Simple Calculator");
        textField = new JTextField();
        textField.setEditable(false);

        // Create buttons for digits and operators
        String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "C", "=", "/"
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        // Set up the frame layout
        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Configure the frame
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                textField.setText(textField.getText() + command);
            } else if (command.charAt(0) == 'C') {
                textField.setText("");
                operator = "";
                num1 = num2 = result = 0;
            } else if (command.charAt(0) == '=') {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                }
                textField.setText(String.valueOf(result));
                operator = "";
            } else {
                if (!operator.isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    textField.setText("");
                }
                operator = command;
                num1 = Double.parseDouble(textField.getText());
            }
        }
    }

    public static void main(String[] args) {
        // Create and display the calculator
        new SimpleCalculator();
    }
}
