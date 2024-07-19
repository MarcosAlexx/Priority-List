package com.todo.todo.service;

import com.todo.todo.entity.Todo;
import com.todo.todo.repository.TodoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TodoService {

    @Autowired
    private TodoRepositoy todoRepository;


    public TodoService(TodoRepositoy todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void create (Todo todo){
        todoRepository.save(todo);
    }

    public java.util.List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public java.util.List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public java.util.List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }

}
