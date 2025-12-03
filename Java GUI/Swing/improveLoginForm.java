// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class improveLoginForm {
//     public static void main(String[] args) {
//         // Step 1: Create JFrame
//         JFrame frame = new JFrame("Login Form");
//         frame.setSize(400, 250);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(new GridBagLayout()); // Use GridBagLayout
//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(5, 5, 5, 5); // Padding

//         // Step 2: Create Components
//         JLabel userLabel = new JLabel("Username:");
//         JTextField userText = new JTextField(15);
//         JLabel passLabel = new JLabel("Password:");
//         JPasswordField passText = new JPasswordField(15);
//         JButton loginButton = new JButton("Login");

//         // Step 3: Add Components to Frame (GridBag Layout)
//         gbc.gridx = 0;
//         gbc.gridy = 0;
//         frame.add(userLabel, gbc);

//         gbc.gridx = 1;
//         frame.add(userText, gbc);

//         gbc.gridx = 0;
//         gbc.gridy = 1;
//         frame.add(passLabel, gbc);

//         gbc.gridx = 1;
//         frame.add(passText, gbc);

//         gbc.gridx = 1;
//         gbc.gridy = 2;
//         frame.add(loginButton, gbc);

//         // Step 4: Button Click Event
//         loginButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 String username = userText.getText();
//                 String password = new String(passText.getPassword());

//                 if (username.equals("ashish") && password.equals("1234")) {
//                     JOptionPane.showMessageDialog(frame, "Login Successful! 🎉");
//                 } else {
//                     JOptionPane.showMessageDialog(frame, "Invalid Username or Password ❌");
//                 }
//             }
//         });

//         // Step 5: Show Frame
//         frame.setLocationRelativeTo(null); // Center the window
//         frame.setVisible(true);
//     }
// }


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class improveLoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Components
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(15);
        JCheckBox showPassword = new JCheckBox("Show Password");
        JButton loginButton = new JButton("Login");

        // Add Components
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(userLabel, gbc);
        gbc.gridx = 1;
        frame.add(userText, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(passLabel, gbc);
        gbc.gridx = 1;
        frame.add(passText, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(showPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        frame.add(loginButton, gbc);

        // Show Password Functionality
        showPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passText.setEchoChar((char) 0); // Show Password
                } else {
                    passText.setEchoChar('*'); // Hide Password
                }
            }
        });

        // Login Button Click Event
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                if (username.equals("Ashish") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful! 🎉");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password ❌");
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}