package dev.gruppuppgift;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProgramTest {
    @Test
    public void testRun() {
        
    }

    @Test
    public void testExtendTimeResetsDaysBorrowed() {
        Book book = new Book("testtitle", "testgenre", "testauthor");
        book.setDaysBorrowed(7);
        assertEquals(7, book.getDaysBorrowed());
        book.extendTime();
        assertEquals(0, book.getDaysBorrowed());
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
    public void testAdvanceDay() {
        Book book = new Book("Title", "Genre", "Author");
        assertEquals(0, book.getDaysBorrowed());
        book.advanceDay();
        assertEquals(1, book.getDaysBorrowed());
        book.advanceDay();
        assertEquals(2, book.getDaysBorrowed());
    }
}
