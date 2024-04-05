package com.example.todolist.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tasks")
public class Todo {

    @Valid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Todo Cannot Be null")
    @NotBlank(message = "Todo Cannot Be Blank")
    private String todo;

    @NotBlank(message = "Todo Priority Cannot Be Blank")
    @NotNull(message = "Priority Cannot Be null")
    private String priority;

    @NotBlank(message = "Todo Status Be Blank")
    @NotNull(message = "Status Cannot Be null")
    private String status;

    // Default constructor (no-argument constructor)
    public Todo() {}

    public Todo(String todo, String priority, String status) {
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
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


    @Override
    public String toString() {
        return "Todo [id=" + id + ", todo=" + todo + ", priority=" + priority + ", status=" + status + "]";
    }

    
    // Constructors, getters, and setters
    
}
