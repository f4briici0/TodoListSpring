package com.fabricio.todolist.repositories;

import com.fabricio.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Todo, Integer> {
}
