package com.jgm.module7.service;

import com.jgm.module7.entity.Book;
import com.jgm.module7.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book create(Book book) {
        return repository.save(book);
    }

    public Book update(Long id, Book book) {
        return repository.save(book);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public Book getById(Long id) {
        return repository.findById(id).get();
    }
}
