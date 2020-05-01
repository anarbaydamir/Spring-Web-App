package com.company.service.impl;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service // Service'e muraciet olunur o da daoya muraciet edir o da database'e,
@Transactional //Transaction burda yazilmasi daha yaxshidi, eger mene her hansi method lazimdisa onu transaction ile bir yerde gonderirem.
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier(value = "userDao1")
    private UserRepositoryCustom userDao;

    @Override
    public List<User> getAll(String name,String surname,Integer nationalityId) {
        return userDao.getAll(name,surname,nationalityId);
    }
    
    @Override
    public User getById(int userID) {
        return  userDao.getById(userID);
    }
    
     @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }
    
    @Override
     public boolean removeUser(int id) {
        return userDao.removeUser(id);
     }

    @Override
    public int addUser(User u) {
        return userDao.addUser(u);
    }
    

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userDao.getUserByEmailAndPassword(email,password);
    }

    @Override
    public User getUserByEmail (String email)
    {
        return userDao.getUserByEmail(email);
    }
}
