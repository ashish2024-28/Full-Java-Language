import java.util.ArrayList;
public class stack{

    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        // push
        public static void push(int data){
            list.add(data);
            System.out.println("push element is : " + data);
        }
        // pop
        public static void pop(){
            if(isEmpty()){
                System.out.println("Stack is Empty, Underflow!");
                return;
            }
            // int top = list.get(list.size()-1);
            int top = list.remove(list.size()-1);
            System.out.println("pop element is : "+ top);
        }
        //peek or top
        public static void peek(){
            if(isEmpty()){
                System.out.println("Stack is Empty, No peek element");
                return;
            }
            System.out.println("peek element is : " + list.get(list.size()-1));
        }
    }
    public static void main (String args[]){
        Stack s = new Stack();
        
        for(int i = 1; i < 6 ; i++){
            s.push(i);
            if(i==4){ s.peek(); }
        }

        for(int i = 1; i < 7 ; i++){
            s.pop();
            if(i==5 || i==1){ s.peek(); }
        }

        s.push(10);
        s.push(20);
        s.peek();
        s.pop();
        s.pop();
        s.pop();

    }

 }