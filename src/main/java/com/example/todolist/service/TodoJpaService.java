package com.example.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todolist.models.Todo;
import com.example.todolist.repository.TodoJpaRepository;
import com.example.todolist.repository.TodoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TodoJpaService implements TodoRepository {

    @Autowired
    private TodoJpaRepository  todoJpaRepository;

    @Override
    public List<Todo> getAllTodos() {
        try {
            return todoJpaRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
        
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoJpaRepository.save(todo);
    }

    @Override
    public Todo getTodoById(int id) {
        Optional<Todo> optionalTodo = todoJpaRepository.findById(id);
        return optionalTodo.orElse(null);
    }
    
    @Override
    public Todo updateTodo(int id, Todo todoDetails) {
        Optional<Todo> optionalTodo = todoJpaRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setStatus(todoDetails.getStatus());
            return todoJpaRepository.save(todo);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteTodo(int id) {
        Optional<Todo> optionalTodo = todoJpaRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todoJpaRepository.delete(todo);
            return true;
        } else {
            return false;
        }
    }
}