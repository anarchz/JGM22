package com.jgm.module7.controller;

import com.jgm.module7.entity.Book;
import com.jgm.module7.repository.BookRepository;
import com.jgm.module7.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/create_form")
    public String getCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/books/create")
    public String create(Model model, @ModelAttribute Book book) {
        bookService.create(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateForm(Model model, @PathVariable("id") Long id) {
        Book book = bookService.getById(id);
        if(book == null) {
            throw new IllegalArgumentException("Invalid id");
        } else {
            model.addAttribute("book", book);
        }
        return "update";
    }

    @PostMapping("/books/update/{id}")
    public String update(Model model, @PathVariable("id") Long id, @ModelAttribute Book book) {
        bookService.update(id, book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
