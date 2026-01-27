 //very first Download Jdk , intellij idea, MySql , MySql Connector , then in intellij open Project Structure -> Libaries click(+)-> (java) (add) mysqlConnector
//  and mysqlConnector add in library

//import required package   1

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.Statement;

import java.sql.*;
import java.util.*;

public class Main2 {

   

        public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);

            try{
                // load Driver  2
                Class.forName("com.mysql.cj.jdbc.Driver");
                // create Connection  3
                    //copy url of db (open mysql and copy jdbc connectin / edit connection)
                String url = "jdbc:mysql://localhost:3307/studentDB1"; // jo db creat kiya ho us ka name like (studentDB) or live (host) live adresh
                String user = "root";
                String password = "Enter Password";
                Connection con = DriverManager.getConnection(url,user,password);

                //create Statement  4
//                String query = "INSERT INTO studentdb VALUE(6,'Java','ashishkumar@gmail.com','Ashish'),(1,'Java','ashishku@gmail.com','Ashish')";

                // prepareStatement one time compile or execute many time
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO studentd VALUE(?,?)");

                //create Statement  5
                // data taken by user
//                pstmt.setInt(1,123);
//                pstmt.setString(2,"ashish");
//                pstmt.setInt(1,1234);
//                pstmt.setString(2,"ashishasda");

                System.out.print("How Many Student Data Enter : ");
                int n = sc.nextInt();
                for(int i=0;i<n;i++){
                    System.out.printf("Enter the data of %d students \n",i+1);
                    System.out.print("Enter Student ID : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Student Name : ");
                    String name = sc.next();
                    pstmt.setInt(1,id);
                    pstmt.setString(2,name);
                    pstmt.executeUpdate();
                }


                // close connectin  6
                con.close();
                System.out.println("data inserted successfully");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }


        }
    }

//this is good way