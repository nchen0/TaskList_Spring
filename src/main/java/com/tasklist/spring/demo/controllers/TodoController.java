package com.tasklist.spring.demo.controllers;

import com.tasklist.spring.demo.entities.Todo;
import com.tasklist.spring.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void addTodo(@Valid @RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public void updateTodo(@Valid @RequestBody Todo todo, @PathVariable int id) {
        todoService.updateTodo(todo, id);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }

//    GET /todos/active - return a listing of the todos not yet completed.
    @GetMapping("/todos/active")
    public List<Todo> getActiveTodos() {
        return todoService.getActiveTodos();
    }

    // POST /users/{userid}/todos - Add a todo based on user ID
    @PostMapping("/users/{userid}/todos")
    public void addUserTodo(@Valid @RequestBody Todo todo, @PathVariable int userid) {
        todoService.addUserTodo(todo, userid);
    }

    // GET /todos/sorted - Sort todos based on description
    @GetMapping("/todos/sorted")
    public List<Todo> getSortedTodos() {
        return todoService.getSortedTodos();
    }
}
