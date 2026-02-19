package com.library.lab03;

import java.time.LocalDate;

public class EBook extends LibraryItem {
    private String downloadUrl;
    private double fileSize;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public EBook(String title, String author, String ISBN, double price, String downloadUrl, double fileSize) {
        super(title, author, ISBN, price,"Available");
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("\n 💻 E-BOOK ");
        super.displayDetails();
        System.out.println(" - Download URL: " + downloadUrl);
        System.out.println(" - File Size: " + fileSize);
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0;
    }
}
