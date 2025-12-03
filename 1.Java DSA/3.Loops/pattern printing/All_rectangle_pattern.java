public class All_rectangle_pattern{
    public static void main(String args[]){
        int m=4,n=5;
        // solid recatngle 
        // nested loop concept
        System.out.println("Solid Rectangle ");
        for(int i=1;i<=m;i++){
            for(int j=1 ;j<=n;j++){
                System.out.print("*");
            } System.out.println();
        }
      // hollo rectangle
        System.out.println("Hollow Rectangle ");
        int r=4,c=5;

        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(i==1 || j==1 || i==4 || j==5){
                   System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            } System.out.println();
        }
    
    }

}