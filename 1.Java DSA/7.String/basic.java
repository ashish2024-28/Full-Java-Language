import java.util.*;
public class basic {
    public static void main(String ashish[]){
         Scanner sc = new Scanner(System.in);

        // String Declaration
         String firstname ="Ashish";
         String lastname = "kumar";

        // adding of two string , Concatenation
         String name = firstname +" "+ lastname; 
         System.out.println(name);

         System.out.println(name.toLowerCase());
         System.out.println(name.toUpperCase());

         System.out.println(name.substring(1,4));
            String n = name.replace("kumar","   radha    ");
         System.out.print("n = "+n);
 
         System.out.print("trim = "+n.trim());

         System.out.println("statsWith(As) = "+name.startsWith("As"));
         
         System.out.println(name.endsWith(" "));
         System.out.println(n.endsWith(" "));
         
         System.out.println(name.charAt(1));

         System.out.println(name.indexOf("r"));

         System.out.println(name.lastIndexOf("r"));

         System.out.println(name.equals("Ashish radha"));

         System.out.println(name.equalsIgnoreCase("Ashish Kumar"));


         System.out.print("enter any thing :");
         String any = sc.nextLine(); //input any thing sc.next() -> for single words or befor space;
         System.out.println(any);

         System.out.println(any.trim());
         

         //length of string
         System.out.println("Length of strings :" + any.length());

        //  int a = 000030105; // behave like Octa decimal <8
         int a = 301067;
         String S = String.valueOf(a);

         System.out.println(S +"  Length of this : "+ S.length());

         int num = 123;
         String str = String.valueOf(num);
         
         System.out.println(str); // Output: "123"


        }
}