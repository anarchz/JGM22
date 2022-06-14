package com.jgm.module7;

import com.jgm.module7.entity.Book;
import com.jgm.module7.repository.BookRepository;
import com.jgm.module7.service.BookService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @InjectMocks
    private BookService service;

    @Mock
    private BookRepository repository;

    @Test
    public void getAllBooks() {
        Book book = new Book("name1", "author",null , 20.2);
        Book book2 = new Book("name2", "author",null , 20.2);
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
        when(repository.findAll()).thenReturn(books);
        List<Book> booksCreated = service.getAllBooks();
        Assertions.assertEquals(books.size(), booksCreated.size());
    }

    @Test
    public void create() {
        Book book = new Book("name1", "author",null , 20.2);
        when(repository.save(any(Book.class))).thenReturn(book);
        Book created = service.create(book);
        Assertions.assertEquals(book.getName(), created.getName());
    }

    @Test
    public void deleteById() {
        service.deleteById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void getById() {
        Book book = new Book(1L,"name1", "author",20.2 , null);
        when(repository.findById(1L)).thenReturn(Optional.of(book));
        Book created = service.getById(1L);
        Assertions.assertEquals(book.getId(), created.getId());
    }

}
