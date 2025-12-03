/* System.out.printf(): 
    This is a special way to print things in Java.
    It allows you to format your output
    %.2f: This is the important part!
        %: This symbol starts a format specifier.
        .2: This means "round to 2 decimal places".
        *f: This means "format as a floating-point number" (a number with decimals).
*/
public class formating_printing{
    public static void main(String args[]){

    //     double x = 108.108;
    //     System.out.println(Math.PI);
    //     System.out.printf("print upto 2 decimal place %.2f \n",Math.PI);
    //     System.out.printf("print upto 2 decimal place %.2f \n",x);
    //    /* Why 108.11 and not 108.10?
    //      Because of the rounding rule. 
    //      Since the third decimal is 8, which is 5 or more, the second decimal is rounded up. */

    //     float n = 5.2f;
    //     System.out.printf("float n= 5.2f --> %.4f \n",n);

    //     n = 2344335.3f;
    //     System.out.printf("float n= 2344335.3f --> %20.4f \n",n);
    //     n = 1002344335.6f;
    //     System.out.printf("float n= 1002344335.39f --> %10.49f \n",n);
 
        // format
        System.out.format("| %15s | %n","java");
        System.out.format("| %-15s | %n","java");

        System.out.printf("| %-15s | %n","java");
        System.out.printf("| %15s | %n","java");

        String Name = "ash";
        int year = 2025;
        double age = 18.5;
        System.out.format("%nName : %s | Year : %d | age : %f %n",Name,year,age);
        System.out.printf("%nName : %s | Year : %d | age : %.2f %n",Name,year,age);
        // both are similar


    }
}

// Output

// 3.141592653589793
// print upto 2 decimal place 3.14 
// print upto 2 decimal place 108.11
// float n= 5.2f --> 5.2000
// float n= 2344335.3f -->         2344335.2500
// float n= 1002344335.39f --> 1002344320.0000000000000000000000000000000000000000000000000