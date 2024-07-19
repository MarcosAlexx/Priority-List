package com.todo.todo.controller;

import com.todo.todo.entity.Todo;
import com.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {


    @Autowired
    private TodoService todoService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody Todo todo){
        todoService.create(todo);
        return ResponseEntity.ok().body("Todo cadastrado com sucesso");
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

}
