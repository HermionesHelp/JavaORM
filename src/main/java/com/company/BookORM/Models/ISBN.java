package com.company.BookORM.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ISBN {

    @Id
    @GeneratedValue
    private int id;

    private String number;

    private String country;
    private Book book;

    // The only constructor we need is an empty one for Hibernate to make an instance.
    // We will need getters and setters in order to complete the creation of objects.
    public ISBN() {}

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}