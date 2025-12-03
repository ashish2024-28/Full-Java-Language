public class basic {
    public static <T> void genericPrint(T t){
        // System.out.println("length is : " + t.length);
        System.out.println("Generic Print is : " + t);
    }
    public static void main(String[] a){

        genericPrint(12345);
        genericPrint("Ashish");
        genericPrint(123.45);
        genericPrint("A");
        genericPrint(true);
        genericPrint(false);
        
      
    }
}