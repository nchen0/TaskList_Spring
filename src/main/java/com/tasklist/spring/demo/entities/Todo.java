package com.tasklist.spring.demo.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_started")
    private Date dateStarted;

    @Column
    private boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Todo() {
    }

    public Todo(String description, Date dateStarted, boolean completed) {
        this.description = description;
        this.dateStarted = dateStarted;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateStarted=" + dateStarted +
                ", completed=" + completed +
                ", user=" + user +
                '}';
    }
}
