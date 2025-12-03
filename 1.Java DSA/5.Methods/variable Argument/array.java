public class array{
    // Strings
    public static void printMany(String elements[]){
        
        System.out.println("Print String value :-");
        for(String e : elements){
            System.out.print(e + "\t");
        }
        System.out.println();
    }

    // integer
    public static void printArray(int arr[]){

        System.out.println("Print Array value :-");
        for(int e : arr){
            System.out.print(e + "\t");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] ashish){

        String[] a = {"1","2","any value"};
        printMany(a);
        
        int[] x = {2,4,5,6,7,8,9,10};
        printArray(x);
        int[] y = {12,14,15,16,17,18,19,20};
        printArray(y);
        // printArray(12,14,15,16,17,18,19,20);
    }
}