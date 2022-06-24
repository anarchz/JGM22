package com.jgm.module6.service;

import com.jgm.module6.entity.User;
import com.jgm.module6.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class UserService  {
    @Autowired
    UserRepository repository;

    public User getUserById(long userId) {
        return repository.findById(userId).get();
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return repository.findAllByName(name, PageRequest.of(pageNum, pageSize));
    }

    @Transactional
    public User createUser(User user) {
        log.info("user created" + user.getId());
        return repository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        log.info("user updated" + user.getId());
        return repository.save(user);
    }

    @Transactional
    public boolean deleteUser(long userId) {
        log.info("user deleted" + userId);
        repository.deleteById(userId);
        return true;
    }

}
