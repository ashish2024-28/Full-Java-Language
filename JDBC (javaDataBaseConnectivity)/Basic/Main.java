
//very first Download Jdk , intellij idea, MySql , MySql Connector , then in intellij open Project Structure -> Libaries click(+)-> (java) (add) mysqlConnector
//  and mysqlConnector add in library

//import required package   1
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try{
            // load Driver  2
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create Connection  3
                //copy url of db (open mysql and copy jdbc connectin / edit connection)
            String url = "jdbc:mysql://localhost:3306/student"; // jo db creat kiya ho us ka name like (studentDB) or live (host) live adresh
            String user = "root";
            String password = "Enter Password";
            Connection con = DriverManager.getConnection(url,user,password);

            //create Statement  4
            Statement stm = con.createStatement();

            // prepareStatement one time compile or execute many time
            PreparedStatement pstmt = con.prepareStatement("select * from student");

            //Execute Query 5
            String query3 = "INSERT INTO studentdb VALUE('Java','ashishkumar@gmail.com','Ashish'),('Java','ashishku@gmail.com','Ashish')";
            String query4 = "INSERT INTO studentdb VALUE('Java','ashishkmar@gmail.com','Ashish'),('Java','ashisu@gmail.com','Ashish')";
            String query2 = "Delete from studentdb where id = 6";
            String query = "update studentdb set id = 2, name = 'Ashish Kumar', email = 'ashihkumar.bcse@2024.huroorkee.come '  where id = 6 ";

//            String query4 = "create database ashish222";
//            String query6 = "use ashish";
//            String query7 = "creat table ashish('id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(100) NOT NULL');";
//            String query8 = "INSERT INTO ashish VALUE(1,'Java','ashishkumar@gmail.com','Ashish'),(1,'Java','ashishku@gmail.com','Ashish')";



            stm.executeUpdate(query);
            stm.executeUpdate(query2);
            stm.executeUpdate(query3);
            stm.executeUpdate(query4);
            // close connectin  6
            con.close();
            System.out.println("data inserted successfully");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}

// this is not good way
// good way in Main2