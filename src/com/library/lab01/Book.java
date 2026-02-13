package com.library.lab01;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String status;
    private LocalDate returnDate;


    public Book(String title, String author, String isbn, double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void displayDetails(){
        System.out.println("\n - Title: "+ title);
        System.out.println(" - Author: "+ author);
        System.out.println(" - ISBN: "+ isbn);
        System.out.println(" - Price: "+ price);
        System.out.println(" - Status: "+ status);

        if (status.equalsIgnoreCase("available")) {
            System.out.println(" - Return Date: N/A (Book is available)");
        } else {
            System.out.println(" - Return Date: "+ returnDate );
        }

    }

    public void checkOut() {
        if ("Borrowed".equalsIgnoreCase(this.status)) {
            System.out.println(" Error: Book ' "+ this.title + " ' is already borrowed and cannot be checked out again.");
            return;
        }

        this.status = "Borrowed";
        this.returnDate = LocalDate.now().plusDays(7);
        System.out.println(" Book ' "+ this.title + " ' has been checked out successfully.");
        System.out.println(" Return Due Date: " + this.returnDate);
    }

    public void returnBook() {
        if (!"Borrowed".equalsIgnoreCase(this.status)) {
            System.out.println(
                    " Error: Book '" + this.title + "' is not currently borrowed."
            );
            return;
        }
        this.status = "Available";
        System.out.println("Book '"+ this.title + " ' has been returned successfully.");
    }

    public void printSummary() {
    }
}
