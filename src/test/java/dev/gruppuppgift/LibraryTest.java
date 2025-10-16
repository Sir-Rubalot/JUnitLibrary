package dev.gruppuppgift;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void testListBorrowedBooks() {
        Library library = new Library();
        library.borrowBook("Harry Potter");
        library.borrowBook("It ends with us");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        library.listBorrowedBooks(true);
        String output = outputStream.toString();
        assertTrue("Output should contain 'Harry Potter", output.contains("Harry Potter"));
        assertTrue("Output should contain 'It ends with us", output.contains("It ends with us"));
        assertEquals("The list should contain 2 borrowed books", 2, library.borrowedBooksList.size());
        System.setOut(System.out);
    }

    @Test
    public void testListBorrowedBooksBy() {

    }

    @Test
    public void testReturnBook() {

    }

    @Test
    public void stockLibrary() {
        
    }
}
