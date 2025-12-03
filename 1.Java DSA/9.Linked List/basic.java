import java.util.LinkedList;
// import java.util.*;

public class basic{
    public static void main(String[] ashish){
        
        LinkedList<Integer> list1 = new LinkedList<>();
        
        LinkedList<String> list2 = new LinkedList<>();

        // Add / insert  / add last
        list1.add(10);          list2.add("Ram");
        list1.add(20);          list2.add("Ram");
        list1.add(30);          list2.add("Ram");
        list1.add(40);          list2.add("Ram");
        list1.add(50);          list2.add("Ram");

        //add first 
        list1.addFirst(1);      list2.addFirst("Sri");

        //print list
        System.out.println("list1 element :- " + list1); 
        System.out.println("list2 element :- " + list2); 

        // list.get() and also print using list.get()
        // list.size()

        System.out.println("Print using list.get() :- ");
        for(int i=0;i<list2.size();i++){
            System.out.print(list2.get(i) + " --> ");
        } System.out.println("null");

        // remove / delete first and last
        int remove = list1.removeFirst();
        System.out.println("list.removefirst() => " + remove);
         remove = list1.removeLast();
        System.out.println("list.removeLast() => " + remove);
        
        //  remove using index
         remove = list1.remove(1);
        System.out.println("list.remove(indx) => " + remove);
        
        // clear
        list1.clear();
        list2.clear();

        
        //print list
        System.out.println("list1 element :- " + list1); 
        System.out.println("list2 element :- " + list2); 
    }
}