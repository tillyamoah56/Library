package com.example.manueleagzample.splashscreen.models;

import java.util.Date;

public class ReservedBook {
    private LibraryBooks book;

    private String reserver;
    private Date reserveDate;
    private Date timeOutDate;

    public ReservedBook() {
    }

    public LibraryBooks getBook() {
        return book;
    }

    public void setBook(LibraryBooks book) {
        this.book = book;
    }

    public String getReserver() {
        return reserver;
    }

    public void setReserver(String reserver) {
        this.reserver = reserver;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getTimeOutDate() {
        return timeOutDate;
    }

    public void setTimeOutDate(Date timeOutDate) {
        this.timeOutDate = timeOutDate;
    }

    public ReservedBook(LibraryBooks book, String reserver, Date reserveDate, Date timeOutDate) {
        this.book = book;
        this.reserver = reserver;
        this.reserveDate = reserveDate;
        this.timeOutDate = timeOutDate;

    }
}
