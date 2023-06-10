package com.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.User;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDAO;

    public void saveUser(User user) {
        userDAO.inserOrUpdatetUser(user);
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public void updateUser(User user) {
        userDAO.inserOrUpdatetUser(user);
    }

    public void deleteUser(User user) {
        userDAO.deleteUer(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUser();
    }
}
