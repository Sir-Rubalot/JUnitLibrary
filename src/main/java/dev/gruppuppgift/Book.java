package dev.gruppuppgift;
public class Book {
    public String name;
    public String genre;
    public String author;
    public boolean borrowed;
    public int daysBorrowed;
    public boolean borrowBookToday;

    public Book(String name, String genre, String author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.borrowed = false;
        this.daysBorrowed = 0;
    }

    public int checkLateFee() {
        if (daysBorrowed > 7) {
        int daysLate = daysBorrowed - 7;
            System.out.println("The book is " + daysLate + " days late");
            return daysLate * 20;
        }
        return 0;
    }

    public void extendTime() {
        this.daysBorrowed = 0;
    }

    public void advanceDay() {
        this.daysBorrowed++;
        this.borrowBookToday = false;
        System.out.println("One day has passed.");
    }

    public void borrowBook() {
        this.borrowed = true;
    }

    public void returnBook() {
        this.borrowed = false;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public int getDaysBorrowed() {
        return daysBorrowed;
    }

    public void setDaysBorrowed(int days) {
        this.daysBorrowed = days;
    }
}
