package com.library.lab02;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private static int nextId = 1001;

    private String title;
    private String author;
    private String isbn;
    private String serialNumber;
    private double price;
    private String status;
    private LocalDate returnDate;
    private final int limitBorrowBooks = 3;


    public Book(String title, String author, String isbn, double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.serialNumber = "BK- " + nextId++;
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

    public void printSummary(){
        System.out.println("Book [Title='" + title + "', Status='" + status + "']");
    }

    public void displayDetails(){
        System.out.println("\n - Title: "+ title);
        System.out.println(" - Author: "+ author);
        System.out.println(" - ISBN: "+ isbn);
        System.out.println(" - Serial Number: "+ serialNumber);
        System.out.println(" - Price: "+ price);
        System.out.println(" - Status: "+ status);

        if (status.equalsIgnoreCase("available")) {
            System.out.println(" - Return Date: N/A (Book is available)");
        } else {
            System.out.println(" - Return Date: "+ returnDate );
        }

    }

    public void checkOut(Member member) {
        if ("Borrowed".equalsIgnoreCase(this.status)) {
            System.out.println(" Error: Book ' "+ this.title + " ' is already borrowed and cannot be checked out again.");
            return;
        }

        if (member.canBorrow()){
            this.status = "Borrowed";
            member.incrementBorrow();
            this.returnDate = LocalDate.now().plusDays(7);
            System.out.println(" Book ["+ this.title + "] has been checked out successfully ");
            System.out.println(" Book ["+ this.title + "] has been borrowed " + member.getMemberName() + ".");
            System.out.println(" Return Due Date: " + this.returnDate + ".");
        }
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
}
