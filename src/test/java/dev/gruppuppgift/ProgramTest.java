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
    public void testBorrowBook() {
        Library library = new Library();
        String title = "Harry Potter";
        library.borrowBook(title);
        boolean found = false;
        for (Book b : library.borrowedBooksList) {
            if (b.getName().equalsIgnoreCase(title)) {
                found = true;
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
