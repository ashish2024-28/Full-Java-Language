// Code sharing through super concept.
class Cat {
    void speak(){
        System.out.println("meaon !.....");
    }
}

class PetCat extends Cat { // PetCat is one type of Cat
    void speak(){
        System.out.println("meow !.....");
    }
}

class MagicCat extends Cat { // MagicCat is another kind of cat
    static boolean noOne;
    void speak(){
        if(noOne){
            super.speak(); // use the super class definition
        }else{
            System.out.println("Hello world !");  
        }
    }
}

class cat_class{
    public static void main(String args[]){
        PetCat c1 = new PetCat();
        MagicCat c2 = new MagicCat();
        c2.noOne = true;
        c2.speak();
        c1.speak(); 
        c2.noOne = false;
        c2.speak();
    }
}