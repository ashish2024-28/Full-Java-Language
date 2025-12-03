public class All_Triangle_pattern{
    public static void main(String args[]){
        int m=5;
        // half pyramid with number
        System.out.println("Half Pyramid with number");
        for(int i=1;i<=m;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println("");            
        }

        // inverted half pyramid with number

        System.out.println("\nInverted Half Pyramid with number ");
        for(int i=m;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println("");            
        }

        // Floyd's Triangle
        System.out.println("\nFloyd's Triangle ");
        int count=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=i;j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }

        // 0-1 Triangle
        System.out.println("\n0 - 1 Triangle ");
        for(int i=1;i<=m;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print(1);
                }
                else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }


    }
}