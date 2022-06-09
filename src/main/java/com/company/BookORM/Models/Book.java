package com.company.BookORM.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Book extends AbstractEntity{

    @NotBlank(message = "Book must have a Title")
    private String title;

    @ManyToOne
    private Author author;

    @OneToOne
    private ISBN isbn;

    @ManyToMany
    private List<Genre> genres;

    public Book() {
    }

    public Book(String title, Author author, ISBN isbn, List<Genre> genres) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genres = genres;
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
