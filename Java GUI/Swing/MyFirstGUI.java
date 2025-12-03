import javax.swing.*; // Import swing library
public class MyFirstGUI{
    public static void main(String[] args){
        // Step 1 ; creat a window (JFrame)
        JFrame frame = new JFrame("My First GUI");

        // step 2 set window size
        frame.setSize(500, 300);

 // step 3 close the window when the user clicks the close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //step 4 make the window visible
        frame.setVisible(true);
    }
}
/*
A GUI (Graphical User Interface) allows users to interact with the program using buttons, text fields, and windows instead of just text in the terminal.

Java Swing provides many components to create a GUI:
✅ JFrame → Creates a window
✅ JButton → Adds a button
✅ JLabel → Displays text
✅ JTextField → Input box for users
✅ JPanel → A container to hold components
 */