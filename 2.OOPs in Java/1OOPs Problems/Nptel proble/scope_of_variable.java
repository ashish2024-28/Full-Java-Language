public class scope_of_variable{
    public static void main(String args[]){

        {
            int x = 10;
            System.out.println("The scope variable of x only b/w {} -> "+x);
        }
            System.out.println("The value of not access outside the {} ");

    }
}