
public class Stack1{
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class Stack{
        public static Node head;
        public static boolean isEmpty(){
            return head == null;
        }
        // push
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                System.out.println("push element is : " + head.data);
                return;
            }
            newNode.next = head;
            head = newNode;
            System.out.println("push element is : " + head.data);
        }
        // pop
        public static void pop(){
            if(head == null){
                System.out.println("Stack is Empty, Underflow!");
                return;
            }
            if(head.next == null){
                System.out.println("pop element is : "+ head.data);
                head = null;
                return;
            }
            System.out.println("pop element is : "+ head.data);
            head = head.next;
        }
        //peek or top
        public static void peek(){
            if(head == null){
                System.out.println("Stack is Empty, No peek element");
                return;
            }
                System.out.println("peek element is : " + head.data);
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