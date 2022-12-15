package com.afs.todolist.controller;

import com.afs.todolist.controller.mapper.TodoMapper;
import com.afs.todolist.entity.Todo;
import com.afs.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    @CrossOrigin
    List<Todo> getAll() {
        return todoService.findAll();
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTodo(@PathVariable String id){
        todoService.deleteById(id);
    }
}
