package com.company.BookORM.Controllers;

import com.company.BookORM.Models.Book;
import com.company.BookORM.dataRepositories.AuthorRepository;
import com.company.BookORM.dataRepositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }

    // GET /book/new -> returns an HTML form
    @GetMapping(value = "/new")
    public String addBookForm(Model model) {
        model.addAttribute(new Book());
        model.addAttribute("authors", authorRepository.findAll());
        return "newBookForm";
    }

    // POST /book/new
    @PostMapping(value = "/new")
    public String addBook(@ModelAttribute @Valid Book newBook, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "newBooKForm";
        }

        bookRepository.save(newBook);
        model.addAttribute("bookName", newBook.getTitle());
        return "bookAdded";
    }

    @GetMapping(value = "/{bookId}")
    public String getBookById(@PathVariable int bookId, Model model) {
        Optional<Book> maybeBook = bookRepository.findById(bookId);

        if (maybeBook.isEmpty()) {
            model.addAttribute("book", "not found");
            return "book-by-id";
        }

        Book foundBook = maybeBook.get();
        model.addAttribute("book", foundBook);

        return "book-by-id";
    }
}