package com.company.BookORM.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Please enter first name.")
    private String firstName;

    @NotBlank(message = "Please enter last name.")
    private String lastName;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAuthorName(){
        return this.lastName + ", " + this.firstName;
    }
}
