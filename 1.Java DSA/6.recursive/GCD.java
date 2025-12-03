public class GCD{
    int m,n;
    int gcd(int m, int n){
        if(m>n){ 
            return gcd(n,m);
        }
        if(m==n) return m;
        if(m==0) return n;
        if(m==1) return 1;
        return gcd(m,n%m);
    }

    public static void main(String args[]){

        if (args.length != 2) {
            System.out.println("Please provide two numbers as command-line arguments.");
            return;
        }

        try {
         GCD g = new GCD();
         g.m = Integer.parseInt(args[0]);
         g.n = Integer.parseInt(args[1]);
         System.out.printf("GCD of %d and %d ->",g.m ,g.n ,g.gcd(g.m,g.n));
        } 
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide integer numbers.");
        }
    }
}