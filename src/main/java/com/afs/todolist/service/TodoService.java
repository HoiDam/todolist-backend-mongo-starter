package com.afs.todolist.service;

import com.afs.todolist.entity.Todo;
import com.afs.todolist.exception.InvalidIdException;
import com.afs.todolist.exception.TodoNotFoundException;
import com.afs.todolist.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    private void validateObjectId(String id){
        if(!ObjectId.isValid(id)){
            throw new InvalidIdException(id);
        }
    }

    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

    public Todo updateById(String id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        if (todo.getText() != null) {
            existingTodo.setText(todo.getText());
        }
        if (todo.getDone() != null) {
            existingTodo.setDone(todo.getDone());
        }
        if (todo.getColor() != null) {
            existingTodo.setColor(todo.getColor());
        }
        return todoRepository.save(existingTodo);
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
