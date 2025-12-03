// import java.util.Stack;
import java.util.*;

public class U_Framework{
    public static void main (String args[]){
        Stack<Integer> s = new Stack<>();
        
        for(int i = 1; i < 6 ; i++){
            System.out.println("push element is : " + s.push(i));
            if(i==5){
                System.out.println("peek element is : " + s.peek());     
            }

        }

        
        for(int i = 1; i < 7 ; i++){
            if(s.isEmpty()){
                System.out.println("Stack is empty , Underflow!");
                return;
            }
            else{
                System.out.println("pop element is : " + s.pop());
            }
            if(i==4){ 
                System.out.println("peek element is : " + s.peek());     
            }

        }

        

        
        
        // s.peek();

    }

}