package dev.gruppuppgift;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BookTest {
    @Test
    public void testAdvanceDay() {

    }

    @Test
    public void testBorrowBook() {

    }
    // Testing if the book is not late
    @Test
    public void testCheckLateFee_NotLate() {
        Book book = new Book("Title", "Genre", "Author");
        book.daysBorrowed = 7;
        assertEquals(0, book.checkLateFee());
    }
    // Testing if the book is late
    @Test
    public void testCheckLateFee_Late() {
        Book book = new Book("Title", "Genre", "Author");
        book.daysBorrowed = 10;
        assertEquals(40, book.checkLateFee());
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
