package dev.gruppuppgift;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class BookTest {
    @Test
    public void testAdvanceDay() {
        Book book = new Book("title", "genre", "author");
        assertEquals(0, book.getDaysBorrowed());
        book.advanceDay();
        assertEquals(1, book.getDaysBorrowed());
    }

    @Test
    public void testBorrowBook() {
        Library library = new Library();
        library.borrowBook("Harry Potter");
        boolean found = false;
        for (Book b : library.borrowedBooksList) {
            if (b.getName().equalsIgnoreCase("Harry Potter")) {
                found = true;
                break;
            }
        }
        assertTrue("Book should be in borrowList", found);
        int sizeBefore = library.borrowedBooksList.size();
        library.borrowBook("Harry Potter");
        int sizeAfter = library.borrowedBooksList.size();
        assertEquals("Wont lend same book twice", sizeBefore, sizeAfter);
    }

    @Test
    public void testCheckNoLateFee() {
        Book book = new Book("Title", "Genre", "Author");
        book.daysBorrowed = 7;
        assertEquals(0, book.checkLateFee());
    }

    @Test
    public void testCheckLateFee_Late() {
        Book book = new Book("Title", "Genre", "Author");
        book.daysBorrowed = 10;
        assertEquals(60, book.checkLateFee());
    }

    @Test
    public void testExtendTime() {

    }

    @Test
    public void testGetAuthor() {

    }

    @Test
    public void testGetDaysBorrowed() {

    }

    @Test
    public void testGetGenre() {

    }

    @Test
    public void testGetName() {

    }

    @Test
    public void testIsBorrowed() {

    }

    @Test
    public void testReturnBook() {

    }
}
