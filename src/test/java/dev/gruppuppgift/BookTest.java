package dev.gruppuppgift;

import static org.junit.Assert.assertEquals;

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
