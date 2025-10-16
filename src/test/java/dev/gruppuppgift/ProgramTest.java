package dev.gruppuppgift;

import static org.junit.Assert.assertEquals;
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
    public void returnBook() {
        
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
