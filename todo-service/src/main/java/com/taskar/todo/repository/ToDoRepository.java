package com.taskar.todo.repository;

import com.taskar.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findTodoByTaskId(Long task_id);
}
