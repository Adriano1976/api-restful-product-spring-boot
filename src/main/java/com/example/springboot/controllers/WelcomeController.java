package com.example.springboot.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    /**
     * Método resonsável em buscar a listagem de informações disponível na base de dados usando outros métodos.
     *
     * @return Retorna uma lista com todos os Products encontrados na base de dados, com um status.
     */
    @ApiOperation(value = "Retorna uma lista de informações da base de dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma confirmação de que as informações foram encontrados."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping(value = "/", produces = "application/json")
    public String welcome() {
        return "Welcome to My Spring Boot Web API";
    }

    /**
     * Método resonsável em buscar a listagem dos usuários disponíveis na base de dados usando outros métodos.
     *
     * @return Retorna uma lista com todos os Products encontrados na base de dados, com um status.
     */
    @ApiOperation(value = "Retorna uma lista de usuários da base de dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma confirmação de que os usuários foram encontrados."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping(value = "/users", produces = "application/json")
    public String users() {
        return "Authorized user";
    }

    /**
     * Método resonsável em buscar a listagem dos administradores disponíveis na base de dados usando outros métodos.
     *
     * @return Retorna uma lista com todos os administradores encontrados na base de dados, com um status.
     */
    @ApiOperation(value = "Retorna uma lista de administradores da base de dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma confirmação de que os administradores foram encontrados."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping(value = "/managers", produces = "application/json")
    public String managers() {
        return "Authorized manager";
    }
}
