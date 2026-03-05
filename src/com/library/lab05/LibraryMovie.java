package com.library.lab05;

import com.library.lab05.DigitalContent;
import com.library.lab05.Member;

import java.time.LocalDate;
import java.util.UUID;

public class LibraryMovie implements DigitalContent {
    private String title;
    private String director;
    private String streamingUrl;
    private double durationMinutes;
    private int releaseYear;
    private String genre;
    private double price;
    private boolean isAvailable;
    private LocalDate returnDueDate;
    private Member borrowedBy;
    private String uniqueId;
    private double fileSize;

    public LibraryMovie(){
        this.uniqueId = UUID.randomUUID().toString();
    }

    public LibraryMovie(String title, String director, String streamingUrl, double durationMinutes, int releaseYear, String genre, double price, double fileSize){
        this.title = title;
        this.director = director;
        this.streamingUrl = streamingUrl;
        this.durationMinutes = durationMinutes;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.price = price;
        this.fileSize = fileSize;
        this.isAvailable = true;
        this.returnDueDate = null;
        this.borrowedBy = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStreamingUrl() {
        return streamingUrl;
    }

    public void setStreamingUrl(String streamingUrl) {
        this.streamingUrl = streamingUrl;
    }

    public double getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(double durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(LocalDate returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Member borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void displayDetails() {
        System.out.println("===== MOVIE DETAILS =====");
        System.out.println("Title: " + this.title);
        System.out.println("Director: " + this.director);
        System.out.println("Release Year: " + this.releaseYear);
        System.out.println("Genre: " + this.genre);
        System.out.println("Duration: " + this.durationMinutes + " minutes");
        System.out.println("Price: " + this.price + " Baht");
        System.out.println("File Size: " + this.fileSize + " MB");
        System.out.println("Available: " + (this.isAvailable ? "Yes" : "No"));
    }

    @Override
    public void streamOnline() {
        System.out.println(" Streaming '" + this.getTitle() + "' from URL: " + this.streamingUrl);
        System.out.println(" Starting online stream... connected");
        System.out.println(" You can now watch the movie online without downloading.");
    }

    @Override
    public void download() {
        System.out.println(" Downloading '" + this.getTitle() + "' from URL: " + this.streamingUrl);
        System.out.printf(" Downloading file... (%.2f MB)\n", this.fileSize);
        System.out.println(" Download complete! File saved to your device.");
        System.out.println(" You can now watch the movie offline.\n");
    }
}
