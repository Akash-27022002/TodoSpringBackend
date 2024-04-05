package com.example.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.models.Todo;
import com.example.todolist.service.TodoJpaService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The TodoController class handles HTTP requests related to Todo entities.
 * It maps various CRUD operations to corresponding endpoints and delegates the
 * business logic to the TodoJpaService.
 * 
 * @RestController annotation marks this class as a Spring REST controller,
 * allowing it to handle incoming HTTP requests.
 * @RequestMapping ("/api/todos") maps the controller to the "/api/todos" URL path.
 */

@RestController
@RequestMapping("/api/todos")
public class TodoController {
     @Autowired
    private TodoJpaService todoService;

     /**
     * GET endpoint to retrieve all Todo objects.
     * 
     * @return List of Todo objects.
     */

    @GetMapping
    public List<Todo> getAllTodos() {
        try {
            return todoService.getAllTodos();
        } catch (Exception e) {
           throw e;
        }
       
    }

    /**
     * GET endpoint to retrieve a Todo object by ID.
     * 
     * @param id The ID of the Todo object to retrieve.
     * @return ResponseEntity with the retrieved Todo object or NOT_FOUND status if not found.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int id) {
        Todo todo = todoService.getTodoById(id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     /**
     * POST endpoint to create a new Todo object.
     * 
     * @param todo The Todo object to be created (validated using @Valid annotation).
     * @return The created Todo object.
     */

    @PostMapping
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    /**
     * PUT endpoint to update an existing Todo object.
     * 
     * @param id The ID of the Todo object to update.
     * @param todoDetails The updated details for the Todo object (validated using @Valid annotation).
     * @return ResponseEntity with the updated Todo object or NOT_FOUND status if not found.
     */

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int id, @Valid @RequestBody Todo todoDetails) {
        Todo updatedTodo = todoService.updateTodo(id, todoDetails);
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     /**
     * DELETE endpoint to delete a Todo object by ID.
     * 
     * @param id The ID of the Todo object to delete.
     * @return ResponseEntity with NO_CONTENT status if deletion is successful, or NOT_FOUND if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        if (todoService.deleteTodo(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


      /**
     * Exception handler for MethodArgumentNotValidException.
     * Handles validation errors and returns a map of field errors.
     * 
     * @param error The MethodArgumentNotValidException thrown during validation.
     * @return Map containing field names and corresponding error messages.
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationException(MethodArgumentNotValidException error){
        Map<String,String> errors = new HashMap<>();

        error.getBindingResult().getAllErrors().forEach((e) ->{
            String fieldName = ((FieldError) e).getField();
            String message = e.getDefaultMessage();

            errors.put(fieldName, message);

        });

        return errors;
    }


}
