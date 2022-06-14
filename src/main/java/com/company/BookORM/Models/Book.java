package com.company.BookORM.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    // This will become a Many-to-One relationship
    private Author author;

    // This will become a One-to-One relationship
    private ISBN isbn;

    // This will become a Many-to-Many relationship
    private List<Genre> genres;

    // The only constructor we need is an empty one for Hibernate to make an instance.
    // We will need getters and setters in order to complete the creation of objects.
    public Book() {
    }

    //    Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    //custom method to add a genre to the current list of genres for a book
    public void addGenre(Genre genre) {
        genres.add(genre);
    }


}
