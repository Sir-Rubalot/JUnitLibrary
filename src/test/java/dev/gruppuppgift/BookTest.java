package dev.gruppuppgift;

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
        Book book = new Book("testTitle", "testTenre", "testAuthor");
        book.setDaysBorrowed(7);
        assertEquals(7, book.getDaysBorrowed());
        book.extendTime();
        assertEquals(0, book.getDaysBorrowed());
    }

    @Test
    public void testGetAuthor() {
        Book book = new Book("title", "genre", "author");
        assertEquals("author", book.getAuthor());
    }

    @Test
    public void testGetDaysBorrowed() {
        Book book = new Book("title", "genre", "author");
        book.setDaysBorrowed(5);
        assertEquals(5, book.getDaysBorrowed());
    }

    @Test
    public void testGetGenre() {
        Book book = new Book("title", "genre", "author");
        assertEquals("genre", book.getGenre());
    }

    @Test
    public void testIsBorrowed() {
        Book book = new Book("title", "genre", "author");
        assertFalse("Book shouldn't be borrowed to start", book.isBorrowed());
        book.borrowBook();
        assertTrue("Book should be borrowed", book.isBorrowed());
        book.returnBook();
        assertFalse("Book shoudlnt be borrowed after returnBook()", book.isBorrowed());
    }

    @Test
    public void testReturnBookAndRemovesFeeCount() {
        Library library = new Library();
        library.borrowBook("Harry Potter");
        Book borrowedBook = null;
        for (Book b : library.borrowedBooksList) {
            if (b.getName().equalsIgnoreCase("Harry Potter")) {
                borrowedBook = b;
                break;
            }
        }
        assertNotNull("Book should be borrowed", borrowedBook);
        borrowedBook.setDaysBorrowed(10);
        int lateFee = library.returnBook("Harry Potter");
        assertEquals("Late fee should be 60kr (3 days late)", 60, lateFee);
        boolean isLeft = false;
        for (Book b : library.borrowedBooksList) {
            if (b.getName().equalsIgnoreCase("Harry Potter")) {
                isLeft = true;
                break;
            }
        }
        assertFalse("Book should be removed from borrowedBooksList", isLeft);
    }
}
