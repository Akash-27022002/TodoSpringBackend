package com.example.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todolist.models.Todo;
import com.example.todolist.repository.TodoJpaRepository;
import com.example.todolist.repository.TodoRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;


/**
 * The TodoJpaService class implements the TodoRepository interface and provides
 * the business logic for CRUD operations on Todo entities using JPA.
 * 
 * This service class is responsible for interacting with the TodoJpaRepository
 * to perform database operations such as fetching, creating, updating, and deleting Todo objects.
 * 
 * @Service annotation marks this class as a Spring service component, allowing it to be automatically
 * detected and managed by the Spring container.
 */

@Service
public class TodoJpaService implements TodoRepository {

    @Autowired
    private TodoJpaRepository  todoJpaRepository;

     /**
     * Retrieves all Todo objects from the database.
     * 
     * @return List of Todo objects.
     * @throws Exception if an error occurs during data retrieval.
     */

    @Override
    public List<Todo> getAllTodos() {
        try {
            return todoJpaRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
        
    }

     /**
     * Creates a new Todo object in the database.
     * 
     * @param todo The Todo object to be created.
     * @return The created Todo object.
     */
    @Override
    public Todo createTodo(@Valid Todo todo) {
        return todoJpaRepository.save(todo);
    }

     /**
     * Retrieves a Todo object from the database based on the provided ID.
     * 
     * @param id The ID of the Todo object to retrieve.
     * @return The retrieved Todo object, or null if not found.
     */

    @Override
    public Todo getTodoById(int id) {
        Optional<Todo> optionalTodo = todoJpaRepository.findById(id);
        return optionalTodo.orElse(null);
    }


    /**
     * Updates an existing Todo object in the database based on the provided ID and details.
     * 
     * @param id The ID of the Todo object to update.
     * @param todoDetails The updated details for the Todo object.
     * @return The updated Todo object, or null if not found.
     */
    
    @Override
    public Todo updateTodo(int id, @Valid Todo todoDetails) {
        Optional<Todo> optionalTodo = todoJpaRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setStatus(todoDetails.getStatus());
            todo.setPriority(todoDetails.getPriority());
            todo.setTodo(todoDetails.getTodo());
            return todoJpaRepository.save(todo);
        } else {
            return null;
        }
    }


     /**
     * Deletes a Todo object from the database based on the provided ID.
     * 
     * @param id The ID of the Todo object to delete.
     * @return true if deletion is successful, false otherwise.
     */
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