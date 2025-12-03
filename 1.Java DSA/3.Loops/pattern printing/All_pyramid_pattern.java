public class All_pyramid_pattern{
    public static void main(String args[]){
        int m=5;
        // half pyramid
        System.out.println("Half Pyramid ");
        for(int i=1;i<=m;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");            
        }

        // inverted half pyramid 
        int n=5;
        System.out.println("Inverted Half Pyramid ");
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");            
        }

        // Half pyramid rotation of 180 deg
        //int n=5;
        System.out.println("Half Pyramid rotation of 180 deg ");
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n-1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");            
        }

         // inverted half pyramid rotation of 180 deg 
       // int n=5;
        System.out.println("Inverted Half Pyramid rotation of 180 deg ");
        for(int i=n;i>=1;i--){
            for(int j=i;j<=n-1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");            
        }

    }
}