
/* 
install MYSQL , JDK , JDBC Connector and set Path in Environment Variable of(JDK , JDBC) and also JDBC ka set Variable path New creat as (CLASSPATH ,variable may => jdbc connector ka path wothour string and add in last (;.;)) 
Check in terminal/cmd 
1. javap -version , javac --version m java --veriosn (check for java(jdk download))
2. javap com.mysql.cj.jdbc.Driver

*/

// Step 1 : import required package or import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class create {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/democrud";
        String username = "root";
        String pass = "radha";

        try {
            // Step 2 : Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3 : Create Connection 
            Connection con = DriverManager.getConnection(url,username,pass);

            // Step 4 : Create Statement or Prepared Statement 
            //Using Prepared Statement create db if not exist and use 
            PreparedStatement pstmt = con.prepareStatement("create database if not exists democrud; \nuse democrud; \ncreate table if not exists studentdb ( \n" + //
                                "id int primary key auto_increment,\n" + //
                                "course varchar(50) not null , \n" + //
                                "email varchar(50) unique not null , \n" + //
                                "name varchar(50)\n" + //
                                ");");
            // System.out.println("Use demo crud operation on batabase : "+pstmt);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner sc = new Scanner(System.in);
            boolean True = true;
            while( True){
                System.out.println("===========================================");
                System.out.println("CRUD Operation :- \n1.Insert Data \n2.Show Data \n3.Update Data \n4.Delete Data \n5.Exit/tarminate the program");
                System.out.print("Select Operation :- ");
                int option = sc.nextInt();
                System.out.println("===========================================\n");
                switch (option) {
                    case 1 :  // Insert Data
                        // prepareStatement one time compile or execute many time
                        String query = "insert into students (name,course,batch) value(?,?,?)";
                        pstmt = con.prepareStatement(query);
                        // System.out.println("insert batabase : "+pstmt);

                        System.out.print("Enter the Number of Student Data Enter : ");
                        int nOfStdudent = sc.nextInt();
                        int i=1,rAffected=0;
                        while (nOfStdudent>=i) {
                            System.out.println("===========================================\n");
                            if(i==1)System.out.printf("Enter %dst Student Data :- \n",i);
                            if(i==2)System.out.printf("Enter %dnd Student Data :- \n",i);
                            if(i==3)System.out.printf("Enter %drd Student Data :- \n",i);
                            if(i>3) System.out.printf("Enter %dth Student Data :- \n",i);
                            System.out.print("Enter Name : ");
                            String Name = br.readLine();   
                            System.out.print("Enter Course and Branch : ");
                            String Course = br.readLine();   
                            System.out.print("Enter Batch : ");
                            String Batch = br.readLine();   

                            // Set Data into DataBase
                            pstmt.setString(1, Name);
                            pstmt.setString(2, Course);
                            pstmt.setString(3, Batch);

                            //Set or Save the Data into Database 
                            rAffected += pstmt.executeUpdate();

                            ++i;
                        }
                        if(rAffected !=0){
                            System.out.println("Data is inserted.. " + rAffected + " row(s) affected.");
                        }
                        else{
                            System.out.println("Data is Not inserted.. " + rAffected + " row(s) affected.");        
                        }

                        break ;
                        
                        case 2: //Show Data
                        //Prepared Statement

                        pstmt = con.prepareStatement("Select * from students;");
                        ResultSet rs = pstmt.executeQuery();
                        // System.out.println("ResultSet : "+rs);
                        
                        while (rs.next() ) {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String course = rs.getString("course");
                            String batch = rs.getString("batch");
                            
                            System.out.printf("id : %d  Name : %s  Course : %s  Batch : %s \n",id,name,course,batch);
                        }
                        
                        rs.close();
                        sc.nextLine();
                        sc.nextLine();
                        break ;
                        
                    case 3: // Update
                        System.out.print("Enter Id to Update Student Data : ");
                        int ID = sc.nextInt();
                        String Uquery = "update students set name=?, course=?, batch=? where id = ?;";
                        // String Uquery = "update students set name=?, course=?, batch=? where id = "+ID+";";
                        // System.out.println(Uquery);
                        pstmt = con.prepareStatement(Uquery);

                        do {
                            System.out.println("===========================================");
                            System.out.print("Enter Name : ");
                            String Name = br.readLine();   
                            System.out.print("Enter Course and Branch : ");
                            String Course = br.readLine();   
                            System.out.print("Enter Batch : ");
                            String Batch = br.readLine();   

                            // Set Data into DataBase
                            pstmt.setString(1, Name);
                            pstmt.setString(2, Course);
                            pstmt.setString(3, Batch);
                            pstmt.setInt(4, ID);

                            //Set or Save the Data into Database 
                            rAffected = pstmt.executeUpdate();
                            if(rAffected !=0)
                                System.out.println("Data is inserted.. " + rAffected + " row(s) affected.");
                            else{
                                System.out.println("Data is Not inserted.. " + rAffected + " row(s) affected.");
                                    
                            }
                            
                        }while (false);
                        
                        
                        
                        sc.nextLine();
                        sc.nextLine();
                        break ;
                        
                        case 4: //Delete
                        
                        System.out.print("Enter id for Delete :");
                        int DId = sc.nextInt(); 
                        String Dquery = "Delete from students where id = ? ;";

                        // String DId = sc.next(); 
                        // String Dquery = "Delete from students where id = DId ;";
                        // Dquery = Dquery.replace("DId",DId );
                        
                        // System.out.println(pstmt = con.prepareStatement(Dquery));
                        pstmt = con.prepareStatement(Dquery);
                        pstmt.setInt(1, DId);
                        rAffected = pstmt.executeUpdate();
                        if(rAffected != 0 ){
                            System.out.println("Delete Successful... " + rAffected + " row(s) affected.");
                        }else{
                            System.out.println("Delete Not Successful... " + rAffected + " row(s) affected.");

                        }
                        sc.nextLine();
                        sc.nextLine();
                        
                        break ;
                        
                    case 5:
                        True = false;
                        break ;

                
                    default:
                        System.out.print("ohh ohh Sorry! \nEnter Valid input Start again... y/n : ");
                        
                        String yn = sc.next();
                        if (yn.charAt(0) == 'n') {
                            True = false;
                        }
                        break ;
                }
            }

            // close connections last step:
            
            sc.close();
            br.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
