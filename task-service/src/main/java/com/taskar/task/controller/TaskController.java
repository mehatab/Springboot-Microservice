package com.taskar.task.controller;

import com.taskar.task.entity.Task;
import com.taskar.task.error.TaskNotFoundException;
import com.taskar.task.service.TaskService;
import com.taskar.task.vo.TaskWithTodo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public Task saveTask(@RequestBody Task task){
        log.info("Inside saveTask of TaskController");
        return taskService.saveTask(task);
    }
    @GetMapping("/{id}")
    public TaskWithTodo findTaskById(@PathVariable("id") Long taskId) throws Exception {
        log.info("Inside findTask of TaskController");
        TaskWithTodo taskWithTodo = new TaskWithTodo();
        taskWithTodo.setTask(taskService.findTaskById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId)));
        taskWithTodo.setTodoList(taskService.getTodoList(taskId));
        return  taskWithTodo;
    }


}
