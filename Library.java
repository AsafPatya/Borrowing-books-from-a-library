
import java.util.ArrayList;
import java.util.List;

public class Library {
    String libraryAddress;
    ArrayList<Book> books;

    public Library (String address){
        libraryAddress = address;
        books = new ArrayList<Book>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void printAddress(){
        System.out.println(libraryAddress);
    }

    /**
     * This method checks the books arrayList to see if the book with the given title exists.
     * If it does and it's not borrowed, it borrows it and alerts the user they've successfully checked it out
     * If it does exists and its borrowed, it alerts the user that the book is already borrowed.
     * If the book does not exist in the library, the user is alerted.
     * @param bookTitle
     * @return
     */
    public void borrowBook(String bookTitle){

        Book libraryBook;
        String libraryBookTitle;

        for (int i=0; i < books.size(); i+=1){
            libraryBook = books.get(i);
            libraryBookTitle = libraryBook.getTitle();

            if (libraryBookTitle.equals(bookTitle)){
                if (!(libraryBook.isBorrowed())){
                    libraryBook.borrowed();
                    System.out.println("You successfully borrowed " + libraryBookTitle);
                    return;
                }
                else {
                    System.out.println("Sorry, this book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
        return;
    }

    /**
     * This method walks through the books ArrayList and prints the title
     * of any book object that is not borrowed. If the library is empty or
     * all of the books are checked out, it will alert the user.
     */
    public void printAvailableBooks(){
        Book LibraryBook;
        boolean libraryIsEmpty = true;

        for (int i=0; i < books.size(); i+=1){
            LibraryBook = books.get(i);
            if (!(LibraryBook.isBorrowed())){
                System.out.println(LibraryBook.getTitle());
                libraryIsEmpty = false;
            }
        }
        if (libraryIsEmpty){
            System.out.println("No books in catalog.");
        }
    }

    /**
     * This method walks through the books ArrayList, searching for the input bookTitle.
     * When found, the book object will be returned and the user will be notified. If the
     * book is not found in the library, the user will be alerted.
     * @param bookTitle
     */
    public void returnBook(String bookTitle)
    {
        Book libraryBook;
        String libraryBookTitle;
        Boolean found = false;

        for(int i = 0; i < books.size(); i+=1)
        {
            libraryBook = books.get(i);
            libraryBookTitle = libraryBook.getTitle();

            if(libraryBookTitle.equals(bookTitle))
            {
                if(libraryBook.isBorrowed())
                {
                    libraryBook.returned();
                    System.out.println("You successfully returned " + libraryBookTitle);
                    found = true;
                    break;
                }
            }
        }

        if(!found)
        {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public static void printOpeningHours()
    {
        System.out.println("Libraries are open daily from 9:00 to 17:00.");
    }

    // Add the missing implementation to this class
    public static void main(String[] args) {
        //Create two libraries
        Library firstLibrary = new Library("CS Faculty");
        Library secondLibrary = new Library("IE&M Faculty");
        //Add four books to the first library
        firstLibrary.addBook (new Book("Harry Potter"));
        firstLibrary.addBook (new Book("To Kill a Mockingbird"));
        firstLibrary.addBook (new Book("JAVA"));
        firstLibrary.addBook (new Book("Calculus For Dummies"));
        //Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses: ");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        //Try to borrow Harry Potter from both libraries
        System.out.println("Borrowing Harry Potter:");
        firstLibrary.borrowBook("Harry Potter");
        firstLibrary.borrowBook("Harry Potter");
        secondLibrary.borrowBook("Harry Potter");
        System.out.println();
        //Print the title of all available books from both libraries
        System.out.println("Books available in the first library");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library");
        secondLibrary.printAvailableBooks();
        System.out.println();
        //Return Harry Potter
        System.out.println("Returning Harry Potter");
        firstLibrary.returnBook("Harry Potter");
        System.out.println();
        // Print the titles of available books from the first library
        System.out.println("Books available in the first library");
        firstLibrary.printAvailableBooks();
    }
}
