package com.service;

import com.dao.Storage;
import com.dao.UserDAO;
import com.model.Event;
import com.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class UserService  {
    private final List<User> users;
    private Map<String, List<?>> storage;

    public UserService() {
        users = new ArrayList<User>();
        storage = Storage.getStorage();
        storage.put("user", users);
    }

    public User getUserById(long userId) {
        for(User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for(User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        List<User> usersByName = new ArrayList<User>();
        for(User user : users) {
            if (user.getName().equals(name)) {
                usersByName.add(user);
            }
        }
        int startIndex = usersByName.size()/pageSize*pageNum-1;
        return usersByName.subList(startIndex, startIndex+pageSize);
    }

    public User createUser(User user) {
        User newUser = new UserDAO(user.getId(), user.getName(), user.getEmail());
        users.add(newUser);
        return newUser;
    }

    public User updateUser(User user) {
        User newUser = new UserDAO(user.getId(), user.getName(), user.getEmail());
        for(User user1 : users) {
            if(newUser.getId() == user1.getId()) {
                users.set(users.indexOf(getUserById(user.getId())), newUser);
            }
        }

        return newUser;
    }

    public boolean deleteUser(long userId) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getId() == userId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
