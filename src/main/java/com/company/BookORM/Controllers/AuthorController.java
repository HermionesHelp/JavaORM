package com.company.BookORM.Controllers;

import com.company.BookORM.Models.Author;
import com.company.BookORM.dataRepositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authorList";
    }

    @GetMapping(value = "/new")
    public String addAuthorForm(Model model){
        model.addAttribute(new Author());
        return "newAuthorForm";
    }

    @PostMapping(value = "/new")
    public String addAuthor(@ModelAttribute @Valid Author newAuthor, Errors errors, Model model) {

        if (errors.hasErrors()){
            return "newBooKForm";
        }

        authorRepository.save(newAuthor);
        model.addAttribute("bookName", newAuthor.getAuthorName());
        return "bookAdded";
    }

}
