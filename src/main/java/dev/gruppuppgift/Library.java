package dev.gruppuppgift;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public ArrayList<Book> booksInStockList;
    public ArrayList<Book> borrowedBooksList;
    private Scanner scanner;
    private boolean borrowBookToday = false;

    public boolean AUTHOR = true;
    public static final boolean GENRE = false;

    public Library() {
        this.booksInStockList = new ArrayList<Book>();
        this.borrowedBooksList = new ArrayList<Book>();
        scanner = new Scanner(System.in);
        stockLibrary();
    }

    public ArrayList<Book> borrowBook(String title) {

        if (borrowedBooksList.size() == 5) {
            System.out.println("You've already borrowed 5 books. Return some and come back.");
            return borrowedBooksList;
        }

        if (borrowBookToday) {
            System.out.println("You may only borrow one book per day");
            return borrowedBooksList;
        }
        for (int i = 0; i < booksInStockList.size(); i++) {
            Book book = booksInStockList.get(i);
            boolean alreadyBorrowed = false;
            
            for (Book b : borrowedBooksList) {
                if (b.getName().equalsIgnoreCase(book.getName())) {
                    alreadyBorrowed = true;
                    break;
                }
            }
            if (book.getName().equalsIgnoreCase(title) && !alreadyBorrowed) {
                Book loancopy = new Book(book.getName(), book.getGenre(), book.getAuthor());
                loancopy.daysBorrowed = 0;
                loancopy.borrowBook();
                booksInStockList.remove(i);
                this.borrowedBooksList.add(loancopy);
                borrowBookToday = true;
                break;
            } else if (book.getName().equalsIgnoreCase(title) && alreadyBorrowed) {
                System.out.println("you've already borrowed this book!");
                break;
            }


            
            /* OLD LOOP
            if (borrowedBooksList.contains(book)) {
                System.out.println("You've already borrowed this book.");
                this.borrowedBooksList.remove(book);
                return borrowedBooksList;
            if (book.getName().equalsIgnoreCase(title) && borrowedBooksList.contains(book)) {
                System.out.println("You've already borrowed this book!");
            } else if (book.getName().equalsIgnoreCase(title)) {
                this.borrowedBooksList.add(book);
            }*/
        }
        System.out.println();

        return borrowedBooksList;
    }

    public int returnBook(String title) {

        int totalLateFee = 0;

        for (int i = 0; i < borrowedBooksList.size(); i++) {
            Book book = borrowedBooksList.get(i);
            if (book.getName().equalsIgnoreCase(title)) {
                this.borrowedBooksList.remove(book);
                int fee = book.checkLateFee();
                totalLateFee += fee;
            }
        }
        System.out.println("You owe us " + totalLateFee + " kr in late fees.");
        System.out.println();

        return totalLateFee;
    }

    public ArrayList<Book> listBorrowedBooks(boolean includeDaysBorrowed) {
        for (int i = 0; i < borrowedBooksList.size(); i++) {
            Book book = borrowedBooksList.get(i);
            System.out.print("Title: " + book.getName());
            if (includeDaysBorrowed) {
                System.out.println(", Days borrowed: " + book.getDaysBorrowed());
            } else {
                System.out.println();
            }
        }
        System.out.println();
        return borrowedBooksList;
    }

    public int extendTime(String title) {

        for (int i = 0; i < borrowedBooksList.size(); i++) {
            Book book = borrowedBooksList.get(i);
            if (book.getName().equalsIgnoreCase(title)) {
                book.extendTime();
                return book.getDaysBorrowed();
            }
        }

        return Integer.MIN_VALUE;
    }

    public void listBorrowedBooksBy(boolean AUTHOR) {
        if (AUTHOR) {
            System.out.println("Authors: ");
            for (int i = 0; i < borrowedBooksList.size(); i++) {
                Book book = borrowedBooksList.get(i);
                System.out.println(book.getAuthor());
            }
            System.out.print("> ");

            String input = scanner.nextLine();
            for (int i = 0; i < borrowedBooksList.size(); i++) {
                Book book = borrowedBooksList.get(i);
                if (book.getAuthor() == input) {
                    System.out.println("Title: " + book.getName());
                }
            }

        } else {
            System.out.println("Genres: ");
            for (int i = 0; i < borrowedBooksList.size(); i++) {
                Book book = borrowedBooksList.get(i);
                System.out.println(book.getGenre());
            }
            System.out.print("> ");

            String input = scanner.nextLine();
            for (int i = 0; i < borrowedBooksList.size(); i++) {
                Book book = borrowedBooksList.get(i);
                if (book.getGenre() == input) {
                    System.out.println("Title: " + book.getName());
                }
            }
        }
    }

    public void advanceDay() {
        for (Book b : borrowedBooksList) {
            b.advanceDay();
        }
        borrowBookToday = false;
    }

    public ArrayList<Book> listAvailableBooks() {
        for (int i = 0; i < booksInStockList.size(); i++) {
            System.out.println("Title: " + booksInStockList.get(i).getName());
        }

        return booksInStockList;
    }

    public void stockLibrary() {
        for (int i = 0; i < 5; i++) {
            Book book = new Book("Harry Potter", "Fantasy", "J.K Rowling");
            booksInStockList.add(book);
        }
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Hitchhiker's guide to the galaxy", "Sci-Fi", "Douglas Adams");
            booksInStockList.add(book);
        }
        for (int i = 0; i < 3; i++) {
            Book book = new Book("It ends with us", "Romance", "Colleen Hoover");
            booksInStockList.add(book);
        }
        for (int i = 0; i < 4; i++) {
            Book book = new Book("Ondskan", "Fictional Autobiography", "Jan Guillou");
            booksInStockList.add(book);
        }
        for (int i = 0; i < 5; i++) {
            Book book = new Book("Tempelriddaren", "Historical Fiction", "Jan Guillou");
            booksInStockList.add(book);
        }
    }
}
