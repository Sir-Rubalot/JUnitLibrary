package dev.gruppuppgift;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class LibraryTest {
    @Test
    public void testAdvanceDay() {
        Book book = new Book("Title", "Genre", "Author");
        assertEquals(0, book.getDaysBorrowed());
        book.advanceDay();
        assertEquals(1, book.getDaysBorrowed());
        book.advanceDay();
        assertEquals(2, book.getDaysBorrowed());
    }
    

    @Test
    public void testExtendTime() {
        Book book = new Book("testTitle", "testTenre", "testAuthor");
        book.setDaysBorrowed(7);
        assertEquals(7, book.getDaysBorrowed());
        book.extendTime();
        assertEquals(0, book.getDaysBorrowed());
    }


    @Test
    public void testListAvailableBooks() {
        Library library = new Library();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        library.listAvailableBooks();
        String output = outputStream.toString();
        assertTrue("Output should contain 'Harry Potter'", output.contains("Harry Potter")); // Just for example
        assertTrue("Output should contain 'ondskan'", output.contains("Ondskan")); // Just for example
        System.setOut(System.out);
        assertTrue(library.listAvailableBooks().size() > 0);
    }

    @Test
    public void testListBorrowedBooksBy() {
        Library library = new Library();
        library.borrowBook("Harry Potter");
        String input = "J.K Rowling\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        library.listBorrowedBooksBy(library.AUTHOR);
        String output = outputStream.toString();
        assertTrue("Output should contain Harry Potter", output.contains("Harry Potter"));
        System.setIn(System.in);
        System.setOut(System.out);
    }
    

    @Test
    public void testReturnBookRemovesBookFromBorrowedList() {
    Library library = new Library();
    library.borrowBook("Harry Potter");
    Book borrowedBook = null;
    for (Book b : library.borrowedBooksList) {
        if (b.getName().equalsIgnoreCase("Harry Potter")) {
            borrowedBook = b;
            break;
        }
    }
    assertNotNull(borrowedBook);
    borrowedBook.setDaysBorrowed(10);
    int lateFee = library.returnBook("Harry Potter");
    assertEquals(60, lateFee);
    boolean isLeft = false;
    for (Book b : library.borrowedBooksList) {
        if (b.getName().equalsIgnoreCase("Harry Potter")) {
            isLeft = true;
            break;
            }
        }
    }
            

    @Test
    public void stockLibrary() {
        Library library = new Library();
        library.booksInStockList.clear();
        library.stockLibrary();
        int antalHarryPotter = 0;
        int antalHitchhikersGuideToTheGalaxy = 0;
        int antalItEndsWithUs = 0;
        int antalOndskan = 0;
        int antalTempelriddaren = 0;
        for (Book b : library.booksInStockList) {
            if(b.getName().equalsIgnoreCase("Harry Potter")) antalHarryPotter++;
            if(b.getName().equalsIgnoreCase("Hitchhiker's Guide To The Galaxy")) antalHitchhikersGuideToTheGalaxy++;
            if(b.getName().equalsIgnoreCase("It ends with us")) antalItEndsWithUs++;
            if(b.getName().equalsIgnoreCase("Ondskan")) antalOndskan++;
            if(b.getName().equalsIgnoreCase("Tempelriddaren")) antalTempelriddaren++;
        }
        assertEquals(5, antalHarryPotter);
        assertEquals(10, antalHitchhikersGuideToTheGalaxy);
        assertEquals(3, antalItEndsWithUs);
        assertEquals(4, antalOndskan);
        assertEquals(5, antalTempelriddaren);
    }
}
