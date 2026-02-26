package com.library.lab04;

public class EBook extends LibraryItem implements DigitalContent, Taxable {
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

    @Override
    public void streamOnline() {
        System.out.println(" Streaming '" + this.getTitle() + "' from URL: " + this.downloadUrl);
        System.out.println(" Starting online stream... connected");
        System.out.println(" You can now read the book online without downloading.");
    }

    @Override
    public void download() {
        System.out.println(" Downloading '" + this.getTitle() + "' from URL: " + this.downloadUrl);
        System.out.printf(" Downloading file... (%.2f MB)\n", this.fileSize);
        System.out.println(" Download complete! File saved to your device.");
        System.out.println(" You can now read the book offline.\n");
    }

    @Override
    public double calculateTax() {
        double standardEBookPrice = 99.0;
        double digitalTexRate = 0.05;
        return standardEBookPrice * digitalTexRate;
    }
}
