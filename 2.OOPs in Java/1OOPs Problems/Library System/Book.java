class Book{
    String Title;
    String author;
    private float price;
    private static int totalBooks;

    Book(String Title, String author,int totalBooks ,float price){
        this.Title = Title;     this.author =author;
        this.price = price;     this.totalBooks = totalBooks;
    }

    // Borrow Book
    void borrowBook(){
        if(totalBooks == 0){
            System.out.println("Sorry !.....\nThis Book is Not Avilable, Please borrow next time...");
            return;
        }
        System.out.printf("Successfuly you borrow the book \n Book Title :- %s , author :- %s \n",this.Title,this.author);
        --this.totalBooks;
    }
    // return Book
    void returnBook(){
            System.out.println("Thank You");
            ++this.totalBooks;

    }
    // get Total Number of books 
    public static int getTotalBooks(){
        return totalBooks;
    }
    // return price of book
    float getPrice(){
        return this.price;
    }
    void setPrice(float price){
        if(price == 0){
            System.out.println("Not set price to 0");
        }
        this.price = price;
            System.out.printf("Successfuly...\n New Pirce of Book is : %f \n",this.price);

    }

// }
// public class libSystem{
    public static void main(String[] a){
        
        Book b1 = new Book("Srimad Bhagavad Gita","Ashish Kumar",5,350);


        System.out.println("Total Number of Book : "+b1.getTotalBooks());

        b1.borrowBook();
        b1.borrowBook();
        b1.borrowBook();
        b1.borrowBook();
        b1.borrowBook();
        System.out.println("Total Number of Book : "+b1.getTotalBooks());
        b1.borrowBook();
        System.out.println("Total Number of Book : "+b1.getTotalBooks());

        b1.returnBook();
        System.out.println("Total Number of Book : "+b1.getTotalBooks());
        b1.returnBook();
        System.out.println("Total Number of Book : "+b1.getPrice());
        b1.setPrice(0);
        b1.setPrice(300);

    }
}