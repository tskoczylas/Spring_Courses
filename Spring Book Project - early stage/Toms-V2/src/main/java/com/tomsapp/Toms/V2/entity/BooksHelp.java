package com.tomsapp.Toms.V2.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public class BooksHelp {
    String bookshelpID;

    public String getBookshelpID() {
        return bookshelpID;
    }

    public void setBookshelpID(String bookshelpID) {
        this.bookshelpID = bookshelpID;
    }
}
