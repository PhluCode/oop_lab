package com.library.lab03;

import java.time.LocalDate;

public class PhysicalBook extends LibraryItem{

    private String shelfLocation;

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public PhysicalBook(String title, String author, String ISBN, double price, String shelfLocation) {
        super(title, author, ISBN, price, "Available");
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void displayDetails(){
        System.out.println("\n 📚 PHYSICAL BOOK");
        super.displayDetails();
        System.out.println(" - Shelf Location: "+ shelfLocation);
    }

    @Override
    public void printSummary(){
        System.out.print("PhysicalBook");
        super.printSummary();
        System.out.print(", Shelf Location = "+ shelfLocation + "]");
        System.out.println();
    }
}
