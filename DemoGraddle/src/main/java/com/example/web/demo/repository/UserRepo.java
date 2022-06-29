package com.example.web.demo.repository;

import com.example.web.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository <UserEntity, Long> {
    UserEntity findByUserName(String userName);
}
