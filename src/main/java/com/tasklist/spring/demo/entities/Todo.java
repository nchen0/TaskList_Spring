package com.tasklist.spring.demo.entities;

import javax.persistence.*;

@Entity
@Table
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String description;

    @Column(name="date_started")
    private int dateStarted;

    @Column
    private boolean completed;

    @Column(name="user_id")
    private int userId;
}
