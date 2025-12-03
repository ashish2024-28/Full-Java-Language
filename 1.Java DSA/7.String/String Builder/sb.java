public class sb{
    public static void main(String args[]){

        StringBuilder  sb = new StringBuilder("Ashish") ;
        // get
        System.out.println("\nsb.charAt(1) = "+sb.charAt(1));
        // set
        sb.insert(6," Kumar");

        System.out.println("insert(6, Kumar) ="+sb);

        // delet
        System.out.println(sb.delete(6,12));

        // Append / Add in list
        sb.append(" Kumar  radha");

        System.out.println("sb.append( Kumar radha ) ="+sb +"\n");
        



    
    // Normal String
        String  b = "Ashish" ;

        // System.out.println(b.charAt(1));

        // in String not posssible to add / insert only in StringBuilder
        // b.insert(6," Kumar");

        // System.out.println(b);
    }
}