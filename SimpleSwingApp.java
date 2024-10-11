import javax.swing.*;

public class SimpleSwingApp {
    public static void main(String[] args) {
        // Create a new JFrame (a window)
        JFrame frame = new JFrame("Simple Swing Example");
        
        // Set the size of the frame
        frame.setSize(400, 300);
        
        // Specify what happens when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        
        // Add the panel to the frame
        frame.add(panel);
        
        // Add components to the panel
        placeComponents(panel);
        
        // Make the frame visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Set the layout manager to null to use absolute positioning
        panel.setLayout(null);
        
        // Create a JLabel
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10, 20, 80, 25); // x, y, width, height
        panel.add(userLabel);
        
        // Create a text field for user input
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        
        // Create a login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }
}
