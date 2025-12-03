// import java.util.*;
import java.util.HashSet;
// Iterator
import java.util.Iterator;

public class basic {
    public static void main(String[] args){

        System.out.println("\n-----HashSet is a Unorder list :-----\n");

        // Creating
        HashSet<Integer> set = new HashSet<>();

        // Insert | Add
        set.add(10);        set.add(20);
        set.add(30);        set.add(40);
        set.add(50);        set.add(60);
        
        System.out.println("HashSet Insert | set.add(00) :- " + set.add(00));
        System.out.println("HashSet Insert | set.add(00) :- " + set.add(00));


        // print all elements of set
        System.out.println("HashSet element :- " + set);
        

        // Delet | Remove
        set.remove(10);       set.remove(60);

        System.out.println("HashSet delete | set.remove(00) :- " + set.remove(00));
        System.out.println("HashSet delete | set.remove(00) :- " + set.remove(00));
        
        System.out.println("HashSet element :- " + set);
        
        // search | contains
        boolean search1 = set.contains(10); 
        boolean search2 = set.contains(20);
        System.out.println("set.contains(10) or (20) | search :- " + search1 + " , " + search2);
        
        // size
        System.out.println("set.size :- " + set.size());


        // Iterator
        Iterator it = set.iterator(); 

        while(it.hasNext()){
            System.out.print(it.next() + " --> ");
        }
        System.out.print("null");


    } 
}

