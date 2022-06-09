package com.company.BookORM.Controllers;

import com.company.BookORM.Models.Author;
import com.company.BookORM.Models.Book;
import com.company.BookORM.dataRepositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    public ArrayList<Author> getAllAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        for(Author author : authorRepository.findAll()) {
            authors.add(author);
        }
        return authors;
    }

    @GetMapping
    public String getAuthors(Model model) {
        model.addAttribute("authors", this.getAllAuthors());
        return "authors";
    }

    @PostMapping
    public String createAuthor(Author newAuthor, Model model) {
        authorRepository.save(newAuthor);
        model.addAttribute("authors", this.getAllAuthors());
        return "authors";
    }

    @GetMapping(value = "/{id}/books")
    public String getBooksByAuthor(@PathVariable int id, Model model) {
        Optional<Author> maybeAuthor = authorRepository.findById(id);
        Author author = new Author();
        ArrayList<Book> authorBooks = new ArrayList<>();
        if(maybeAuthor.isPresent()) {
            author = maybeAuthor.get();
            authorBooks.addAll(author.getBooks());
        }
        model.addAttribute("author", author);
        model.addAttribute("books", authorBooks);
        return "author-books";
    }
}