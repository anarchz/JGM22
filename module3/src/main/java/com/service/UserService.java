package com.service;

import com.dao.Storage;
import com.dao.UserDAO;
import com.model.Event;
import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class UserService  {
    @Autowired
    UserRepository repository;

    public UserService() {
    }

    public User getUserById(long userId) {
        return repository.findById(userId);
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return repository.findAllByName(name);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    public boolean deleteUser(long userId) {
        repository.deleteById(userId);
        return true;
    }

}
