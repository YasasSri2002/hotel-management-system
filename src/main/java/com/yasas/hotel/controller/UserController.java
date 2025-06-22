package com.yasas.hotel.controller;

import com.yasas.hotel.entity.UserEntity;
import com.yasas.hotel.model.UserModel;
import com.yasas.hotel.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserModel>create(@RequestBody UserModel user){
        return userService.create(user);
    }

    @GetMapping
    public ResponseEntity<Iterable<UserEntity>>getUser(){
        return userService.get();
    }
}
