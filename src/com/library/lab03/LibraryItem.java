package com.library.lab03;

import java.time.LocalDate;

public class LibraryItem {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String isAvailable;
    private LocalDate returnDate;

    public LibraryItem(String title, String author, String ISBN, double price, String isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = ISBN;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void checkOut(Member member) {
        if ("Borrowed".equalsIgnoreCase(this.isAvailable)) {
            System.out.println(" Error: Book ' "+ this.title + " ' is already borrowed and cannot be checked out again.");
            return;
        }

        if (member.canBorrow()){
            this.isAvailable = "Borrowed";
            member.incrementBorrow();
            this.returnDate = LocalDate.now().plusDays(7);
            System.out.println(" Book ["+ this.title + "] has been checked out successfully ");
            System.out.println(" Book ["+ this.title + "] has been borrowed " + member.getMemberName() + ".");
            System.out.println(" Return Due Date: " + this.returnDate + ".");
        }
    }

    public void displayDetails(){
        System.out.println(" - Title: "+ title);
        System.out.println(" - Author: "+ author);
        System.out.println(" - ISBN: "+ isbn);
        System.out.println(" - Price: "+ price + " Baht");
        System.out.println(" - Status: "+ isAvailable);

        if (isAvailable.equalsIgnoreCase("available")) {
            System.out.println(" - Return Date: N/A (Book is available)");
        } else {
            System.out.println(" - Return Date: "+ returnDate );
        }
    }

    public void printSummary(){
        System.out.print(" [Title='" + title + "', Status='" + isAvailable );
    }

    public void returnItem() {
        if (!"Borrowed".equalsIgnoreCase(this.isAvailable)) {
            System.out.println(
                    " Error: Book '" + this.title + "' is not currently borrowed."
            );
            return;
        }
        this.isAvailable = "Available";
        System.out.println("Book '"+ this.title + " ' has been returned successfully.");
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * 5;
    }
}
