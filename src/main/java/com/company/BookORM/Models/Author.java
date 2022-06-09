package com.company.BookORM.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Author extends AbstractEntity{

    @NotBlank(message = "Please enter first name.")
    private String firstName;

    @NotBlank(message = "Please enter last name.")
    private String lastName;

    @OneToMany(mappedBy = "author")
    public List<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    custom method to return the name in a format that we prefer for the application
    public String getAuthorName(){
        return this.lastName + ", " + this.firstName;
    }

    public List<Book> getBooks() {
        return books;
    }
}
