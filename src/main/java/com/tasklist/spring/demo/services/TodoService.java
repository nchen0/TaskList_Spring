package com.tasklist.spring.demo.services;

import com.tasklist.spring.demo.entities.Todo;
import com.tasklist.spring.demo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return todo.get();
        } else {
            throw new RuntimeException("Did not find todo with id: " + id);
        }
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void updateTodo(Todo updatedTodo, int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            updatedTodo.setId(id);
            updatedTodo.setDateStarted(todo.get().getDateStarted());
            todoRepository.save(updatedTodo);
        } else {
            throw new RuntimeException("Did not find todo with id: " + id);
        }
    }
}
