package com.example.web.demo.controller;

import com.example.web.demo.entity.ToDoEntity;
import com.example.web.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity todo,
                                     @RequestParam Long userId){

        try{
            return ResponseEntity.ok(todoService.createTodo(todo, userId));

        } catch(Exception e){
            return ResponseEntity.badRequest().body("cant create todo");

        }

    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){

        try{
            return ResponseEntity.ok(todoService.completeTodo(id));
        } catch(Exception e){
            return ResponseEntity.badRequest().body("cant complete todo");
        }

    }
}
