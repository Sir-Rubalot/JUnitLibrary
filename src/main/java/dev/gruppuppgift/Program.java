package dev.gruppuppgift;
import java.util.Scanner;

public class Program {
    Scanner scanner = new Scanner(System.in);
    Library library;
    public int daysBorrowed;

    public void run() {
        library = new Library();

        while (true) {
            System.out.println("Welcome to the library! \n" +
                    "Press B to borrow a book \n" +
                    "Press R to return a book \n" +
                    "Press L to list all currently borrowed books \n" +
                    "Press A to list all currently borrowed books by an author \n" +
                    "Press G to list all currently borrowed books by genre \n" +
                    "Press E to extend borrowing \n" +
                    "Press Q to exit");
            System.out.print("> ");
            String input = scanner.nextLine();

            switch (input.toUpperCase()) {
                case "B":
                    borrowBook();
                    break;
                case "R":
                    returnBook();
                    break;
                case "L":
                    library.listBorrowedBooks(true);
                    break;
                case "A":
                    library.listBorrowedBooksBy(Library.AUTHOR);
                    break;
                case "G":
                    library.listBorrowedBooksBy(Library.GENRE);
                    break;
                case "E":
                    extendTime();
                    break;
                case "D":
                    advanceDay();
                case "Q":
                    System.out.println("Exit program.");
                    System.exit(0);
                    break;
                default:
                    break;
            }

            library.advanceDay();
        }
    }

    public void advanceDay() {
        this.daysBorrowed++;
    }

    public void extendTime() {
        System.out.println("Which book do you want to extend?");
        library.listBorrowedBooks(false);
        System.out.print("> ");

        String input = scanner.nextLine();
        library.extendTime(input);
    }

    public void returnBook() {
        System.out.println("Which book do you want to return?");
        library.listBorrowedBooks(false);
        System.out.print("> ");

        String input = scanner.nextLine();

        library.returnBook(input);
    }

    public void borrowBook() {
        System.out.println("Which book do you want to borrow?");
        library.listAvailableBooks();
        System.out.print("> ");

        String input = scanner.nextLine();
        library.borrowBook(input);
    }

}
