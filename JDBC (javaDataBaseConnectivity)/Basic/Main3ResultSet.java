//very first Download Jdk , intellij idea, MySql , MySql Connector , then in intellij open Project Structure -> Libaries click(+)-> (java) (add) mysqlConnector
//  and mysqlConnector add in library

//import required package   1

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.Scanner;

//import required package   1
import java.sql.*;
import java.util.*;

public class Main3ResultSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            // load Driver  2
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create Connection  3
            //copy url of db (open mysql and copy jdbc connectin / edit connection)
            String url = "jdbc:mysql://localhost:3307/studentDB"; // jo db creat kiya ho us ka name like (studentDB) or live (host) live adresh
            String user = "root";
            String password = "Enter Password";
            Connection con = DriverManager.getConnection(url,user,password);

            //create Statement  4

            // prepareStatement one time compile or execute many time
            // ResultSet use for collect the data from db in row and column
            PreparedStatement pstmt = con.prepareStatement("select  * from studentd");

            //create Statement  5
            ResultSet rs = pstmt.executeQuery();

            // collect data from db and rs.next check row wise
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String password1 = rs.getString("password");
//                System.out.println(rs.getString(1)) ;
//                System.out.println(rs.getString(2));

                System.out.printf("Id : %d , Name : %s  \n",id,name);
//
//                System.out.printf("Id : %d , Name : %s , Email : %s , password : %s \n",id,name,email,password1);
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

