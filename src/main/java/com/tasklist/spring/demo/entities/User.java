package com.tasklist.spring.demo.entities;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String username;

    // If we do the below, when we do getUsers(), we'll see each user with their todos.
    //    @OneToMany(fetch = FetchType.LAZY, mappedBy="user", cascade = CascadeType.ALL)
    //    private List<Todo> todos;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public List<Todo> getTodos() {
//        return todos;
//    }
//
//    public void setTodos(List<Todo> todos) {
//        this.todos = todos;
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
