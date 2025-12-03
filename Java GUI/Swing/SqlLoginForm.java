import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlLoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // UI Components
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(userLabel, gbc);
        gbc.gridx = 1;
        frame.add(userText, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(passLabel, gbc);
        gbc.gridx = 1;
        frame.add(passText, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(loginButton, gbc);

        // Login Button Action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful! 🎉");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password ❌");
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Database Connection and Login Validation
    public static boolean validateLogin(String username, String password) {
        boolean isValid = false;
        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the Database
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/UserDB", "root", "yourpassword"
            );

            // Step 3: Prepare SQL Query
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Step 4: Execute Query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Check if a matching user exists
            if (rs.next()) {
                isValid = true;
            }

            // Step 6: Close Connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isValid;
    }
}