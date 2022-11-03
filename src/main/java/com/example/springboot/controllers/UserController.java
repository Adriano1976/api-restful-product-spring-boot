package com.example.springboot.controllers;

import com.example.springboot.models.UserModel;
import com.example.springboot.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável em disponibilizar um recurso HTTP para cadastrar um usuário.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Faz a inserção de um novo usuário na base de dados.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma confirmação de que um novo usuário foi salvo com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping(value = "/users", produces = "application/json", consumes = "application/json")
    public void postUser(@RequestBody UserModel userModel) {
        userService.createUser(userModel);
    }
}
