package com.tasklist.spring.demo.repositories;

import com.tasklist.spring.demo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByCompletedFalse();
    public List<Todo> findAllByOrderByDescription();
}
