package dev.gruppuppgift;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProgramTest {
    @Test
    public void testRun() {

    }

    @Test
    public void extendTime() {
        
    }

    @Test
    public void returnBook() {
        
    }

    @Test
    public void borrowBook() {
        
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
