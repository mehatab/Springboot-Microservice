package com.taskar.task.service;

import com.taskar.task.entity.Task;
import com.taskar.task.repository.TaskRepository;
import com.taskar.task.vo.TaskWithTodo;
import com.taskar.task.vo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Task saveTask(Task task) {
        log.info("Inside saveTask of TaskService");
        return  taskRepository.save(task);
    }

    public Optional<Task> findTaskById(Long taskId) throws Exception {
        log.info("Inside findTaskById of TaskService");
        return  taskRepository.findById(taskId);
    }

    public List<Todo> getTodoList(Long taskId) {
        return restTemplate.exchange("http://TODO-SERVICE/todo/1", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Todo>>() {}).getBody();
    }
}

