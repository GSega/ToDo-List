package com.example.web.demo.repository;

import com.example.web.demo.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<ToDoEntity, Long> {
}
