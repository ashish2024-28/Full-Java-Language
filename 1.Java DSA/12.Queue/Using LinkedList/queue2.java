public class queue2{
    static class Node{
       int data;
       Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class Queue{
            static Node head = null;
            static Node tail = null;

        public static boolean isEmpty(){
            return head ==null && tail == null;
        }

        // add or Enqueue
        public static void Enque(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = tail = newNode;
                System.out.printf("Enqueue element is : %d \n",tail.data); 
                return;
            }
            tail.next = newNode;
            // tail = newNode;
            tail = tail.next;
            System.out.printf("Enqueue element is : %d \n",tail.data); 
           
        }

        // remove
        public static void Deque (){
            if(isEmpty()){
                System.out.println("Queue is Empty , Underflow!");
                return;
            }
            if(head == tail){
                System.out.printf("Deque element is : %d \n",head.data); 
                tail = head = null;
                return;
            }

            System.out.printf("Deque element is : %d \n",head.data); 
            head = head.next;
        
        }
        // peek value print
        public static void Peek (){
            if(isEmpty()){
                System.out.println("Queue is Empty , No Peek");
            }
            else{
                System.out.println("Peek element is "+ head.data);
            }
            
        }


    }
    public static void main (String args[]){

        Queue q = new Queue();

        q.Enque(10);
        q.Enque(20);
        q.Enque(30);
        q.Enque(40);
        q.Enque(50);

        q.Peek();

        q.Enque(60);

        q.Deque();
        q.Deque();
        q.Deque();
        q.Deque();
        
        q.Peek();

        q.Deque();
        q.Deque();
        
        q.Peek();

        q.Deque();
        q.Deque();



    }
}