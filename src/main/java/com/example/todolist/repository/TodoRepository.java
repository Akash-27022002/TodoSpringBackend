package com.example.todolist.repository;

import java.util.List;
import com.example.todolist.models.Todo;


/**
 * The TodoRepository interface defines methods for CRUD operations on Todo entities.
 * 
 * - getAllTodos(): Returns a list of all Todo objects in the repository.
 * - createTodo(Todo todo): Creates a new Todo object and adds it to the repository.
 * - getTodoById(int id): Retrieves a Todo object from the repository based on the provided ID.
 * - updateTodo(int id, Todo todoDetails): Updates an existing Todo object in the repository with new details.
 * - deleteTodo(int id): Deletes a Todo object from the repository based on the provided ID.
 * 
 * This interface serves as a contract for data access operations related to Todo entities,
 * allowing other parts of the application to interact with Todo data without knowledge of
 * the underlying data access implementation (e.g., JPA, Hibernate).
 * 
 * Implementations of this interface provide the actual logic for interacting with the data store,
 * such as a database or in-memory repository, ensuring separation of concerns and modularity in the application.
 */


public interface TodoRepository{
    List<Todo> getAllTodos();
    Todo createTodo(Todo todo);
    Todo getTodoById(int id);
    Todo updateTodo(int id, Todo todoDetails);
    boolean deleteTodo(int id);
}