package com.tasklist.spring.demo.controllers;

import com.tasklist.spring.demo.entities.Todo;
import com.tasklist.spring.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public void addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public void updateTodo(@RequestBody Todo todo, @PathVariable int id) {
        todoService.updateTodo(todo, id);
    }

}
