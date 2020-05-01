package com.company.service.inter;

import com.company.entity.User;

import java.util.List;

public interface UserServiceInter {
    public List<User> getAll(String name, String surname, Integer nationalityId);

    public User getById(int userID);

    public int addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(int id);

    public User getUserByEmailAndPassword(String email, String password);

    public User getUserByEmail(String email);
    
}
