// Import necessary Java Swing and AWT (Abstract Window Toolkit) libraries
import javax.swing.*; // For JFrame, JPanel
import java.awt.*;    // For Graphics, Color, Dimension

// Define a class HelloWorld that extends JPanel (used for custom drawing)
public class HelloWorld extends JPanel {

    // Constructor (used to initialize the JPanel)
    public HelloWorld() {
        setPreferredSize(new Dimension(500, 500)); // Set the panel size to 500x500 pixels
        setBackground(Color.CYAN); // Set the background color of the panel to cyan
    }

    // Override the paintComponent method to customize the drawing
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method to ensure proper rendering

        // Set color to black and fill the entire background manually
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); // Draw a black rectangle covering the panel

        // Set color to red and draw the text "Hello World!"
        g.setColor(Color.RED);
        g.drawString("Hello World!", 50, 50); // Draw text at coordinates (50,50)
    }

    // Main method (starting point of the Java program)
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World"); // Create a new window with title "Hello World"
        HelloWorld panel = new HelloWorld(); // Create an instance of HelloWorld panel
        frame.add(panel); // Add the panel to the frame

        frame.pack(); // Automatically resize frame to fit preferred size of panel (500x500)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close application when window is closed
        frame.setVisible(true); // Make the window visible
    }
}




// applet print hello, world

 /*
import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.drawString("Hello, World!", 50, 50); 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorld"); 
        HelloWorld panel = new HelloWorld(); 
        frame.add(panel); 
        frame.setSize(300, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true); 
    }
}

*/

// applet print hello, world

/*

import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the parent class's paintComponent method
        g.drawString("Hello World! NPTCL", 150, 150); // Draw the string "Hello World!" at (150, 150)
    }

    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Hello World Program");
        
        // Create an instance of HelloWorld (our JPanel)
        HelloWorld panel = new HelloWorld();
        
        // Add the panel to the frame
        frame.add(panel);
        
        // Set the frame size
        frame.setSize(400, 300);
        
        // Close the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}

*/



/*
import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JPanel {

    // Constructor
    public HelloWorld() {
        setPreferredSize(new Dimension(500, 500)); // Set panel size
        setBackground(Color.CYAN); // Set panel background color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fill the background manually
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); 

        // Set text color and draw text
        g.setColor(Color.RED);
        g.drawString("Hello World!", 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        HelloWorld panel = new HelloWorld();
        frame.add(panel);

        frame.pack(); // Adjust frame size based on preferred size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
*/





