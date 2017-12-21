package com.integritas.cellphonebay.service;

import com.integritas.cellphonebay.model.User;
import com.integritas.cellphonebay.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;


    public User findById(Long id) {
        return repository.findOne(id);
    }

    public User findByName(String name) {
        return repository.findByName(name);
    }

    public void saveUser(User obj) {
        repository.save(obj);
    }

    public void updateUser(User obj){
        saveUser(obj);
    }

    public void deleteUserById(Long id){
        repository.delete(id);
    }


    public List<User> findAllUsers(){
        return repository.findAll();
    }

    public boolean isUserExist(User obj) {
        return findByName(obj.getUserName()) != null;
    }
}
