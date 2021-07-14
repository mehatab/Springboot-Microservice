package com.taskar.todo.controller;

import com.taskar.todo.entity.Todo;
import com.taskar.todo.service.ToDoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@Slf4j
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/")
    public Todo saveToDo(@RequestBody Todo todo){
        log.info("Inside saveToDo of ToDoController");
        return toDoService.saveToDo(todo);
    }


    @GetMapping("/{id}")
    public List<Todo> findToDo(@PathVariable("id") Long taskId){
        log.info("Inside findToDo of ToDoController");
        return toDoService.findTodoByTaskId(taskId);
    }
}
