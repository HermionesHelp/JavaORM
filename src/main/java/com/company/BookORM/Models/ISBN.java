package com.company.BookORM.Models;

import javax.persistence.OneToOne;

public class ISBN extends AbstractEntity{

    private String number;
    private String country;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @OneToOne
    private Book book;

    public ISBN() {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
