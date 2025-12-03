import java.io.*;
class java_io__{
    public static void main(String args[] ) throws Exception{
        Float principalAmount = new Float(0);
        Float rateOfInterest = new Float(0);
        int numberOfYear = 0;

        // try{
            DataInputStream in = new DataInputStream(System.in);

            String tempString;
            System.out.println("Enter principal Amount");
            System.out.flush();
            tempString = in.readLine();

            principalAmount  = Float.valueOf(tempString);
            System.out.print("Enter Rate of Interest ");
            System.out.flush();
            tempString = in.readLine();
            rateOfInterest = Float.valueOf(tempString);
            System.out.print("Enter Number of Year ");
            System.out.flush();
            tempString = in.readLine();
            numberOfYear = Integer.parseInt(tempString);
            float interestToatal = principalAmount * rateOfInterest * numberOfYear;
            System.out.println("Total Interest = " + interestToatal);
            
        // }
        // catch(Exception ex){}

    }
}