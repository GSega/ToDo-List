package com.example.web.demo.entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    List<ToDoEntity> todos;

    public UserEntity() {
    }

    public List<ToDoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDoEntity> todos) {
        this.todos = todos;
    }
                                   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



