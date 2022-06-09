package com.company.BookORM.Models;

import javax.persistence.ManyToMany;
import java.util.List;

public class Genre extends AbstractEntity{

    private String type;

    @ManyToMany(mappedBy = "genres")
    public List<Book> books;

    // custom method to add a new book to the book list
    public void addBook(Book book){
        books.add(book);
    }

    public Genre() {
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

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
