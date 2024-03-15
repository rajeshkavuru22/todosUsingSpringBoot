package com.example.todo;

import java.util.*;
import com.example.todo.Todo;

public interface TodoRepository {
    ArrayList<Todo> getTodos();

    Todo getTodoById(int id);

    Todo addTodo(Todo todoObj);

    Todo updateTodo(int id, Todo todoObj);

    void deleteTodo(int id);

}