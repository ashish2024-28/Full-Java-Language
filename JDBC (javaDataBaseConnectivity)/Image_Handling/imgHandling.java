import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.*;
import java.util.Scanner;

class imgHandling {

    public static void main(String[] args) {
        
          
        // String url = "jdbc:mysql://localhost:3306/";
        String url = "jdbc:mysql://localhost:3306/ImageHandling";
        String username = "root";
        String pass = "radha";
        // String query = "create database if not exists demoImage; ";
        // String q2 =  "use demoImage;";
        // String q3 = "create table if not exists imageTable( imgId int auto_increment primary key, imgData LongBLoB Not Null, UploadDate TimeStamp default current_timestamp);";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        try {
            // Step 2 : Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 3 : Create Connection 
            Connection con = DriverManager.getConnection(url,username,pass);


            boolean True = true;
            while (True) {

                System.out.println("===========================================");
                System.out.println("Image Handling Operation :- \n1.Insert Image. \n2.Download Image. \n3.Show Images  \n4.Delete Image \n5.Exit/tarminate the program");
                System.out.print("Select Operation :- ");
                int option = sc.nextInt();
                System.out.println("===========================================\n");

                switch (option) {
                    case 1: //Insert Image
                        System.out.print("Enter Your Image Path in \" \" : ");
                        sc.nextLine();
                        String img_path = br.readLine();
                        if(img_path.length() <= 2){
                            img_path = "D:\\pp\\61JOQrUB8sL.jpg";
                            
                        }
                        String[] imgName = img_path.split("\\\\");

                        FileInputStream FIS = new FileInputStream(img_path);  
                        //  .avilable like length  
                        byte[] imgData = new byte[FIS.available()];
                        // read and store in imgData
                        FIS.read(imgData);

                        PreparedStatement pstmt = con.prepareStatement("Insert into imageStore(imgData,imgName) value(?,?);");

                        pstmt.setBytes(1,imgData);
                        pstmt.setString(2,imgName[imgName.length-1]);
                        
                        int affected = pstmt.executeUpdate();
                        if(affected >0){
                            System.out.println("Imager inseted.."+affected+" row(s) Affected.");
                        }
                        else{
                            System.out.println("image not inserted..");
                        }


                        // sc.nextLine();
                        sc.nextLine();

                        break;

                    case 2:  // Download

                        System.out.println("Enter Your Folder Path for Download in \" \" ");
                        
                        String folderPath = br.readLine();
                        if(folderPath.length()<=2){
                            // folderPath = "D:\\pp";
                            folderPath = "D:\\pp\\New folder";
                        }
                        
                        // String ImageSave = folderPath + "jdbc_Download.jpg";

                        try {
                            
                            // pstmt = con.prepareStatement("Select imgData from imageTable where img_id = ? ");
                            pstmt = con.prepareStatement("Select * from imagestore;");
                            ResultSet rs = pstmt.executeQuery();

                            if (rs.next()) {
                                byte[] imgSData = rs.getBytes("imgData");
                                String imgSName = rs.getString("imgName");

                                // remember this steps
                                folderPath = folderPath + "jdbc download" + imgSName;
                                OutputStream os = new FileOutputStream(folderPath);
                                // binary data worite on imgName2save path
                                os.write(imgSData);

                                System.out.println("Image Download Successfuly...");

                            }
                            else{
                                System.out.println("Not accessing error...");
                            }

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        sc.nextLine();
                        sc.nextLine();

                        break;

                     case 3: //Show Data
                        //Prepared Statement

                        pstmt = con.prepareStatement("Select * from imagestore;");
                        ResultSet rs = pstmt.executeQuery();
                        // System.out.println("ResultSet : "+rs);
                        
                        while (rs.next() ) {
                            int id = rs.getInt("Imgid");
                            String name = rs.getString("Imgname");
                            String Update = rs.getString("UploadDate");
                            
                            System.out.printf("Imgid : %d  Imgname : %s  Update : %s \n",id,name,Update);
                        }
                        
                        rs.close();
                        sc.nextLine();
                        sc.nextLine();
                        break ;
                    
                     case 4: //Delete
                        
                        System.out.print("Enter id for Delete :");
                        String DId = sc.next(); 
                        String Dquery = "Delete from imageStore where id = ? ;";
                        // Dquery = Dquery.replace("DId",DId );
                        
                        pstmt = con.prepareStatement(Dquery);
                        int rAffected = pstmt.executeUpdate();
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
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }
    
}