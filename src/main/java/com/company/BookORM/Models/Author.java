package com.company.BookORM.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Author{

    @Id
    @GeneratedValue
    private int id;

//    @NotBlank(message = "Please enter first name.")
    private String firstName;

//    @NotBlank(message = "Please enter last name.")
    private String lastName;

    @OneToMany(mappedBy = "author")
    public List<Book> books;

    public Author() {
    }


//    custom method to return the name in a format that we prefer for the application
    public String getFullName(){
        return this.lastName + ", " + this.firstName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
