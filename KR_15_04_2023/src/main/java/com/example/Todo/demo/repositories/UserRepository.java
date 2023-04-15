package com.example.Todo.demo.repositories;

import com.example.Todo.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
