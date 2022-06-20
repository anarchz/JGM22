package com.jgm.module3_1.service;

import com.jgm.module3_1.entity.User;
import com.jgm.module3_1.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    void getUserById() {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        User user2 = new User(2L, "name2", "email2@gmail.com");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        Assertions.assertEquals(user1, userService.getUserById(1L));
    }

    @Test
    void createUser() {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        when(userRepository.save(user1)).thenReturn(user1);

        Assertions.assertEquals(user1, userService.createUser(user1));
    }


    @Test
    void updateUser() {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        when(userRepository.save(user1)).thenReturn(user1);

        Assertions.assertEquals(user1, userService.updateUser(user1));
    }

    @Test
    void deleteUser() {
        userRepository.save(new User(1L, "name1", "email1@gmail.com"));
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}