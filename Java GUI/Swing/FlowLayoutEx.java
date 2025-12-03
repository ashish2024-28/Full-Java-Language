import javax.swing.*;
// import java.awt.*;
import java.awt.FlowLayout;

public class FlowLayoutEx{
    public static void main(String[] args){
        // Step 1: Create the JFrame (window)
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new FlowLayout());  // Set layout to FlowLayout
        
        JButton b1 = new JButton("Button b1");
        JButton b2 = new JButton("Button b2");
        JButton b3 = new JButton("Button b3");

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);

        frame.setVisible(true);
    }
}