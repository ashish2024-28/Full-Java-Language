    

// import java.sql.*;
// import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GoodWay {

    private static final String URL = "jdbc:mysql://localhost:3306/democrud";
    private static final String USER = "root";
    private static final String PASS = "radha";

    public static void main(String[] args) {

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Database + Table (Only once)
            initializeDatabase();

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 Scanner sc = new Scanner(System.in)) {

                while (true) {

                    System.out.println("\n===== CRUD MENU =====");
                    System.out.println("1. Insert");
                    System.out.println("2. Show");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("5. Exit");
                    System.out.print("Enter option: ");
                    int choice = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    switch (choice) {
                        case 1 ->{ insertStudent(con, sc); sc.nextLine(); }

                        case 2 -> { showStudents(con); sc.nextLine(); }
                        case 3 -> { updateStudent(con, sc); sc.nextLine(); }
                        case 4 -> { deleteStudent(con, sc); sc.nextLine(); sc.nextLine(); }
                        case 5 -> {
                            System.out.println("Program Terminated.");
                            return;
                        }
                        default -> { System.out.println("Invalid Choice!"); sc.nextLine(); }
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create DB + Table
    private static void initializeDatabase() throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", USER, PASS);
             Statement stmt = con.createStatement()) {

            stmt.execute("CREATE DATABASE IF NOT EXISTS democrud");
        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS students (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(50),
                        course VARCHAR(50),
                        batch VARCHAR(50)
                    );
                    """);
        }
    }

    private static void insertStudent(Connection con, Scanner sc) throws Exception {
        String sql = "INSERT INTO students(name, course, batch) VALUES (?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Batch: ");
            String batch = sc.nextLine();

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, batch);

            int rows = ps.executeUpdate();
            System.out.println("Inserted..: " + rows + " row(s) Affected.");
        }
    }

    private static void showStudents(Connection con) throws Exception {
        String sql = "SELECT * FROM students";

        try (PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            System.out.println("----- Student Records -----");
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Course: %s, Batch: %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getString("batch"));
            }
        }
    }

    private static void updateStudent(Connection con, Scanner sc) throws Exception {
        String sql = "UPDATE students SET name=?, course=?, batch=? WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Course: ");
            String course = sc.nextLine();

            System.out.print("Enter New Batch: ");
            String batch = sc.nextLine();

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, batch);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            System.out.println("Updated: " + rows + " row(s).");
        }
    }

    private static void deleteStudent(Connection con, Scanner sc) throws Exception {
        String sql = "DELETE FROM students WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            System.out.println("Deleted..: " + rows + " row(s) Affected.");
        }
    }

}
