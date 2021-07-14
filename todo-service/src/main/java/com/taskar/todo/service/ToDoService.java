package com.taskar.todo.service;

import com.taskar.todo.entity.Todo;
import com.taskar.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public Todo saveToDo(Todo todo) {
        return toDoRepository.save(todo);
    }

    public List<Todo> findTodoByTaskId(Long taskId) {
        return toDoRepository.findTodoByTaskId(taskId);
    }
}
