package com.example.manueleagzample.splashscreen.models;

import java.util.Date;

public class LibraryBooks {
    private String title;
    private String bookid;
    private String author;
    private String category;
    private boolean borrowable;
    private boolean pdfSupported;
    private boolean referenceOnly;
    private int count;
    private String coverPage;
    private Date publishingDate;

    public LibraryBooks() {
    }

    public LibraryBooks(String title, String bookid, String author, String category, boolean borrowable, boolean pdfSupported, boolean referenceOnly, int count,String coverPage,
                        Date publishingDate) {
        this.title = title;
        this.bookid = bookid;
        this.author = author;
        this.category = category;
        this.borrowable = borrowable;
        this.pdfSupported = pdfSupported;
        this.referenceOnly = referenceOnly;
        this.count = count;
        this.coverPage = coverPage;
        this.publishingDate=publishingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean getBorrowable() {
        return this.borrowable;
    }

    public void setBorrowable(boolean borrowable) {
        this.borrowable = borrowable;
    }

    public boolean getPdfsupported() {
        return this.pdfSupported;
    }

    public void setPdfsupported(boolean pdfSupported) {
        this.pdfSupported = pdfSupported;
    }

    public boolean getReferenceOnly() {
        return this.referenceOnly;
    }

    public void setReferenceOnly(boolean referenceonly) {
        this.referenceOnly = referenceonly;
    }

    public String getCoverPage() { return this.coverPage; }

    public void setCoverPage(String CoverPage) { this.coverPage = coverPage; }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public boolean isAvailable() {
        return this.count > 0;
    }

    @Override
    public String toString() {
        return "LibraryBooks{" + "title='" + title + '\'' + ", bookid='" + bookid + '\'' + ", author='" + author + '\'' + ", category='" + category + '\'' + ", borrowable=" + borrowable + ", pdfSupported=" + pdfSupported + ", referenceOnly=" + referenceOnly + ", count=" + count + ", coverPage='" + coverPage + '\'' + ", publishingDate=" + publishingDate + '}';
    }
}

