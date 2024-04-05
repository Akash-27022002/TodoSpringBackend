package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.models.Todo;



/**
 * The TodoJpaRepository interface extends JpaRepository, which provides CRUD operations
 * for the Todo entity in the database.
 * 
 * This interface is crucial for interacting with the Todo entity in the database,
 * allowing us to perform operations such as saving, updating, deleting, and querying Todo objects.
 * 
 * @param Todo 
 * @param Integer in the JpaRepository will tellin that The primary Key in the Entity Todo is Integer
 * 
 * The use of annotations like @param NotBlank and @param NotNull in the Todo entity class ensures data validation,
 * preventing blank or null values for specific fields, which helps maintain data integrity.
 * These annotations are essential for ensuring the consistency and accuracy of data stored in the database
 * and used within the Todo object instances.
 */

public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {
    
}
