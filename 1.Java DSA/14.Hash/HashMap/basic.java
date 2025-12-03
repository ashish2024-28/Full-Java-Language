// import java.util.*;
import java.util.HashMap;
// Iterator
import java.util.Iterator;

public class basic {
    public static void main(String[] args){

        System.out.println("\n-----HashMap is a Unorder list and main role is Kay (unique) and Value (same|diff) -----\n");

        // Creating map key (unique) and value (same | diff)
        HashMap<String , Integer> map = new HashMap<>();

        // Insert | Add    map.put(key,value);
        map.put("India",1400);        map.put("Bharat",1201);
        map.put("U.P",100);          map.put("U.K",200);
        
        System.out.println("HashSet Insert | set.put(\"Patna\",10) :- " + map.put("Patna",10));


        // print all elements of set
        System.out.println("HashMap element :- " + map);
        
        // Update
        map.put("India",1000);
        System.out.println("HashMap element :- " + map);


        // Delet | Remove   map.remove("key")
        System.out.println("HashMap delete | map.remove(\"U.K\") :- " + map.remove("U.K"));
        
        System.out.println("HashSet element :- " + map);
        
        // search | contains
        boolean search = map.containsKey("India"); 
        System.out.println("set.containsKey(\"India\")  | search :- " + search);
        
        // get value fo key
        System.out.println("set.get(\"Bharat\")  | search :- " + map.get("Bharat"));
        

        // size
        System.out.println("map.size :- " + map.size());


        // Iterator
        
        // for(map.Entry<String,Integer> e : map.entrySet()){
        //     System.out.println(e.getKey());
        //     System.out.println(e.getValue());
        // }

        // Set<String> key = map.keySet();
        // for(String key : key){
        //     System.out.print(key+ "map.get(key)");
        // }


    } 
}

