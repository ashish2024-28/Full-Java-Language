
import java.util.ArrayList;
// import java.util.*;

import java.util.Collections;

public class basic{
    public static void main(String[] ashish){ 

        // Arraylist for integer
        ArrayList<Integer> list1 = new ArrayList<>();
        
        // Arraylist for String
        ArrayList<String> list2 = new ArrayList<>();
        
        // Arraylist for Boolean
        ArrayList<Boolean> list3 = new ArrayList<>();

        // Add / Insert
        list1.add(0); list1.add(1); list1.add(2);

        list2.add("Radha"); list2.add("Shayam"); list2.add("Gurudev"); list2.add("hum"); 
        
        list3.add(true); list3.add(true); list3.add(false); 

        // Print
        System.out.println("List1 elements :- " +list1);
        System.out.println("List2 elements :- " +list2);
        System.out.println("List3 elements :- " +list3);

        // Add between in list
        list1.add(0,100);
        System.out.println("List1 elements :- " +list1);

        // get
        int a = list1.get(0);
        System.out.println(a);

        // set / change 
        list1.set(0,111);
        list2.set(0,"Radha Rani");
        System.out.println("List1 elements :- " +list1);
        System.out.println("List2 elements :- " +list2);
        
        // delet / remove 
        int l1 = list1.remove(0);
        String l2 = list2.remove(list2.size()-1);
        Boolean l3 = list3.remove(0);
        System.out.println("remove elements are :- "+l1 +" , "+ l2 +" , "+ l3);
        // System.out.println("List1 elements :- " +list1);
        // System.out.println("List2 elements :- " +list2);
        // System.out.println("List3 elements :- " +list3);
        
        //size      list.size();
        System.out.println("size of List1 :- " +list1.size());
        System.out.println("size of List2 :- " +list2.size());
        System.out.println("size of List3 :- " +list3.size());
        
        //also print using loop
        for(int i = 0; i<list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        
        for(String e:list2){
            System.out.print(e +" ");
        }
        System.out.println();

        // Sorting use import java.util.collections;
        Collections.sort(list2);
        System.out.println(list2);

        // Clear 
        list1.clear();
        list2.clear();
        list3.clear();

        System.out.println("All list are :- " + list1 + " "+ list2 +" "+ list3);


    }
}