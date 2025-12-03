// Attempting to create an object of interface
class useC {
    public static void main(String args[]){
        // C c = new C(); // Error: Object cannot be instantiated

        C c2; //Ok: Declaration of object is possible

        C c3[] = new C[3]; // this is also Ok: decleration of
        // array of objects for an interface is permitted
    }
}