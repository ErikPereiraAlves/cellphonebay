package com.integritas.cellphonebay.service;

import com.integritas.cellphonebay.model.User;

import java.util.List;

public interface UserService {


    public User findById(Long id);

    public User findByName(String name) ;

    public void saveUser(User obj);

    public void updateUser(User obj);

    public void deleteUserById(Long id);

    public List<User> findAllUsers();

    public boolean isUserExist(User obj);

}
