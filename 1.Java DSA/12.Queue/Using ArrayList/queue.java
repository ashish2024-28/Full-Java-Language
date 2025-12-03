// import java.util.*;
import java.util.ArrayDeque;
import java.util.Queue;
public class queue{
    public static void main(String args[]){
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        // add 
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // peek , print front 
        q.peek();

        // print
        System.out.println(q);

        // remove
        q.remove();

        System.out.println(q);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}