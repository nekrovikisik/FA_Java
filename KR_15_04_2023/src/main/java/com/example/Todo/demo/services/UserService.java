package com.example.Todo.demo.services;

import com.example.Todo.demo.models.User;
import com.example.Todo.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService() {
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
    public void addUser(String login, String surname, String lastname, String middlename, java.sql.Date birthday){
        User user = new User(login, surname, lastname, middlename, birthday);
        userRepository.save(user);
    }


    public User getUser(Integer id) {
        return (User)this.userRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
        this.userRepository.deleteById(id);
    }

}
