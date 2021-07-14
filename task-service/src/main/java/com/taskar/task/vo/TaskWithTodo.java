package com.taskar.task.vo;

import com.taskar.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskWithTodo {
    private Task task;
    private List<Todo> todoList;
}
