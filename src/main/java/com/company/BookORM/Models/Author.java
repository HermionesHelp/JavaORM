package com.company.BookORM.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Author{

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    public List<Book> books;

    // The only constructor we need is an empty one for Hibernate to make an instance.
    // We will need getters and setters in order to complete the creation of objects.
    public Author() {
    }

    //    custom method to return the name in a format that we prefer for the application
    public String getFullName(){
        return this.lastName + ", " + this.firstName;
    }

    //    Getters and Setters
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

    //    Only need a getter for the books list
    public List<Book> getBooks() {
        return books;
    }
}