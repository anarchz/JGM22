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

    // TODO:Should it be moved to BookRepositoryImpl class with using persistent context?
    public Book update(Long id, Book book) {
        Book updated = repository.findById(id).get();
        updated.setAuthor(book.getAuthor());
        updated.setName(book.getName());
        updated.setPrice(book.getPrice());
        updated.setPublishDate(book.getPublishDate());

        return repository.save(updated);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public Book getById(Long id) {
        return repository.findById(id).get();
    }
}
