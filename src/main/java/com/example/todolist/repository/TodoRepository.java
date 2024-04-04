package com.example.todolist.repository;

import java.util.List;


import com.example.todolist.models.Todo;

public interface TodoRepository{
    List<Todo> getAllTodos();
    Todo createTodo(Todo todo);
    Todo getTodoById(int id);
    Todo updateTodo(int id, Todo todoDetails);
    boolean deleteTodo(int id);
}