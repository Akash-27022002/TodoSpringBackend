package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.models.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {
    
}
