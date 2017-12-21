package com.integritas.cellphonebay.repository;

import com.integritas.cellphonebay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    List<User> getUsers();

    User findUser(int userId);

    void saveUser(User user);

    void deleteUser(User user);

}
