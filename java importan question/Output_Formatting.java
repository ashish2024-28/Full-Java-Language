import java.util.*;

public class Output_Formatting {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String si=sc.next();
                int x=sc.nextInt();
                //Complete this line
            
                System.out.print(si);
                    for(int k=0;k<(15-si.length());k++){
                        System.out.print(" ");
                    }
                    System.out.printf("%03d%n",x);
                   
                    
                
            
                //  String s2=sc.next();
                // int y=sc.nextInt();
                // String s3=sc.next();
                // int z=sc.nextInt();
            }
            System.out.println("================================");

    }
}



