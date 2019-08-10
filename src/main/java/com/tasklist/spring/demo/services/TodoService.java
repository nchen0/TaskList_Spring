package com.tasklist.spring.demo.services;

import com.tasklist.spring.demo.entities.Todo;
import com.tasklist.spring.demo.repositories.TodoRepository;
import com.tasklist.spring.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(int id) {
        return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Did not find todo with id: " + id));
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
            throw new ResourceNotFoundException("Did not find todo with id: " + id);
        }
    }

    public void deleteTodo(int id) {
        if (todoRepository.findById(id).isPresent()) {
            todoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Did not find todo with id: " + id);
        }
    }
}
