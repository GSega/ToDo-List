package com.example.web.demo.controller;

import com.example.web.demo.entity.UserEntity;
import com.example.web.demo.exception.UserAlreadyExistException;
import com.example.web.demo.exception.UserNotFoundException;
import com.example.web.demo.repository.UserRepo;
import com.example.web.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user){
        try{
            userService.registraton(user);
            return ResponseEntity.ok("user saved");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }


    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){

        try{
            return ResponseEntity.ok(userService.getOne(id));
        } catch(UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(userService.delete(id));
        } catch(Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }


}
