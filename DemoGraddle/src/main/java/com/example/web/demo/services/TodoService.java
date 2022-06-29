package com.example.web.demo.services;

import com.example.web.demo.entity.ToDoEntity;
import com.example.web.demo.entity.UserEntity;
import com.example.web.demo.model.Todo;
import com.example.web.demo.repository.TodoRepo;
import com.example.web.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo (ToDoEntity todo, Long userId ){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }


    public Todo completeTodo (Long Id ){
        ToDoEntity todo = todoRepo.findById(Id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));

    }
}
