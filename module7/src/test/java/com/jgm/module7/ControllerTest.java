package com.jgm.module7;

import com.jgm.module7.entity.Book;
import com.jgm.module7.repository.BookRepository;
import com.jgm.module7.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class ControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private BookRepository repository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .defaultRequest(get("/").with(user("user").password("password")))
                .apply(springSecurity())
                .build();
    }

    //TODO: avoid     @DirtiesContext

//    @AfterEach
//    public void after() {
//        repository.deleteAll();
//    }

    @Test
    @DirtiesContext
    public void readBook_whenGetBooks_Status200() throws Exception {
        repository.save(new Book("name", "author", null, 20.2));
        mvc.perform(get("http://localhost:8000/rest/books")).andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    public void deleteBook_whenGetBooks_Status200() throws Exception {
        repository.save(new Book("name1", "author", null, 20.2));
        repository.save(new Book("name2", "author", null, 20.2));
        repository.save(new Book("name3", "author", null, 20.2));
        mvc.perform(get("http://localhost:8000/rest/books/delete/3")).andExpect(status().isOk());
        Assertions.assertEquals(repository.findAll().size(), 2);
    }

    @Test
    @DirtiesContext
    public void updateBook_whenGetBooks_Status200() throws Exception {
        Date date = new Date();
        repository.save(new Book("name1", "author",date , 20.2));
        Book book = new Book(1,"name1", "author", 20.2, date);
        repository.save(book);
        mvc.perform(get("http://localhost:8000/rest/books/1")).andExpect(status().isOk());
        Assertions.assertEquals(1, repository.findAll().size());
    }

    @Test
    @DirtiesContext
    public void createBook_whenGetBooks_Status200() throws Exception {
        repository.save(new Book("name1", "author",null , 20.2));
        mvc.perform(get("http://localhost:8000/rest/books/1")).andExpect(status().isOk());
        Assertions.assertEquals(1, repository.findAll().size());
    }
}
