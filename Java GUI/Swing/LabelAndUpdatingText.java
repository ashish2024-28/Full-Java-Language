import javax.swing.*;  
import java.awt.event.*;  

public class LabelAndUpdatingText {
    public static void main(String[] args) {
        // Step 1: Create the JFrame (window)
        JFrame frame = new JFrame("Label Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // Disable default layout
        
        // Step 2: Create a JLabel (label)
        JLabel label = new JLabel("Hello, click the button!");  
        label.setBounds(120, 50, 200, 30);  // Set position & size
        
        // Step 3: Create a JButton (button)
        JButton button = new JButton("Click Me!");
        button.setBounds(130, 100, 120, 40);
        
        // Step 4: Add an ActionListener to change the label text
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked! 🎉");
            }
        });

        // Step 5: Add components to the frame
        frame.add(label);
        frame.add(button);

        // Step 6: Make the frame visible
        frame.setVisible(true);
    }
}