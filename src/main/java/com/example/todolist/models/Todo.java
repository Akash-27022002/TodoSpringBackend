package com.example.todolist.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tasks")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String todo;
    private String priority;
    private String status;

      // Default constructor (no-argument constructor)
      public Todo() {
        
    }
    

    public Todo(String todo, String priority, String status) {
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Constructors, getters, and setters
    
}
