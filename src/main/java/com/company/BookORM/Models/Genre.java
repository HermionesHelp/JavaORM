package com.company.BookORM.Models;

import org.hibernate.annotations.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Genre{

    @Id
    @GeneratedValue
    private int id;

    private String type;
    public List<Book> books;

    // The only constructor we need is an empty one for Hibernate to make an instance.
    // We will need getters and setters in order to complete the creation of objects.
    public Genre() {
    }

    //    Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genre(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Book> getBooks() {
        return books;
    }

    //    Only need a getter for the books list
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // custom method to add a new book to the book list
    public void addBook(Book book){
        books.add(book);
    }
}
