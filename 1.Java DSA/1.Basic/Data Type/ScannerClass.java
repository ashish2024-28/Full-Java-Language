import java.util.Scanner;
public class ScannerClass{
    public static void main(String args[]){

        // Scanner Class
        
        Scanner sc = new Scanner(System.in);
        
        // here String c is top because of press Enter then it not get input by use
        System.out.println("Enter String(with Space) :");
        String c = sc.nextLine();
        
        System.out.println("Enter int Number :");
        int a = sc.nextInt();

        System.out.println("Enter float Number :");
        float b = sc.nextFloat();


        System.out.println("Enter String(without Space) :");
        String d = sc.next();

        System.out.println("Enter Boolean :");
        boolean e = sc.nextBoolean();

        System.out.println("Enter byte :");
        byte f = sc.nextByte();
        
        System.out.println("Enter Double :");
        double g = sc.nextDouble();

        System.out.println("Enter Long :");
        long h = sc.nextLong();
    
        System.out.println("Enter short :");
        short i = sc.nextShort();

        
        System.out.println("All entered is : "+a+" \t" +b+ "\t" +c+ "\t" +d+ "\t" +e+ "\t" +f+ "\t" +g+ "\t" +h+ "\t" +i );

    }
}