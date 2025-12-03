import javax.swing.*;
// import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    public static void main(String[] args) {
        // Step 1: Create the JFrame (window)
        JFrame frame = new JFrame("Login Form"); // creat a window for login form
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Disable automatic layout

        // Step 2: Create Labels (Username & Password)
        JLabel userLabel = new JLabel("Username:"); // Adds a textfield for username
        userLabel.setBounds(30, 30, 80, 25); // Position & size
        JLabel passLabel = new JLabel("Password:");  //Adds a password field(hidden input)
        passLabel.setBounds(30, 70, 80, 25);

        // Step 3: Create Text Fields (Input fields)
        JTextField userText = new JTextField();
        userText.setBounds(120, 30, 150, 25);
        JPasswordField passText = new JPasswordField();
        passText.setBounds(120, 70, 150, 25);

        // Step 4: Create a Login Button
        JButton loginButton = new JButton("Login"); // Adds a button for login
        loginButton.setBounds(120, 110, 80, 30);

        // Step 5: Add ActionListener to Button (Handle Click)
        loginButton.addActionListener(new ActionListener() {  //Handles button click event
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                // Check if username and password are correct
                if (username.equals("Ashish") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful! 🎉");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password ❌");
                }
            }
        });

        // Step 6: Add Components to Frame
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(loginButton);

        // Step 7: Show the Window
        frame.setVisible(true);
    }
}

/*
Let's build a Login Form using Java Swing. This will include:
✅ JLabel → To display "Username" and "Password" text.
✅ JTextField → To enter the username.
✅ JPasswordField → To enter the password (hidden characters).
✅ JButton → A "Login" button.
✅ ActionListener → To handle the button click event.

✅ Try logging in with:

Username: Ashish

Password: 1234

If correct, "Login Successful!" appears.

If wrong, "Invalid Username or Password" appears.

 */