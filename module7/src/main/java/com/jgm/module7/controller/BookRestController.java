package com.jgm.module7.controller;

import com.jgm.module7.entity.Book;
import com.jgm.module7.service.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {
    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/rest/books")
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @PostMapping("/rest/books/create")
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @PostMapping("/rest/books/update/{id}")
    public Book update(@PathVariable("id") Long id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @GetMapping("/rest/books/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/rest/books/{id}")
    public void getOne(@PathVariable("id") Long id) {
        bookService.getById(id);
    }
}
