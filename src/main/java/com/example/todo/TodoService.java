package com.example.todo;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;

import java.util.*;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    int uniqId = 6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    @Override
    public ArrayList<Todo> getTodos() {
        Collection<Todo> todoCollection = todoList.values();
        ArrayList<Todo> todos = new ArrayList<>(todoCollection);
        return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        if (todoList.get(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return todoList.get(id);
    }

    @Override
    public Todo addTodo(Todo todoObj) {
        todoObj.setId(uniqId);
        todoList.put(uniqId, todoObj);
        uniqId += 1;
        return todoObj;
    }

    @Override
    public Todo updateTodo(int id, Todo todoObj) {
        Todo existingTodo = todoList.get(id);

        if (existingTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (todoObj.getTodo() != null) {
            existingTodo.setTodo(todoObj.getTodo());
        }

        if (todoObj.getPriority() != null) {
            existingTodo.setPriority(todoObj.getPriority());
        }

        if (todoObj.getStatus() != null) {
            existingTodo.setStatus(todoObj.getStatus());
        }

        return existingTodo;
    }

    @Override
    public void deleteTodo(int id) {
        Todo todoObj = todoList.get(id);
        if (todoObj == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
