package com.example.springboot.controllers;

import com.example.springboot.models.UserModel;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável em disponibilizar um recurso HTTP para cadastrar um usuário.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void postUser(@RequestBody UserModel userModel) {
        userService.createUser(userModel);
    }
}
