package com.example.springboot.controllers;

import com.example.springboot.dtos.Login;
import com.example.springboot.dtos.Sessao;
import com.example.springboot.models.UserModel;
import com.example.springboot.repositories.UserRepository;
import com.example.springboot.security.JWTCreator;
import com.example.springboot.security.JWTObject;
import com.example.springboot.configurations.SecurityConfig;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Classe responsável em realizar o login e a gerar o token.
 */
@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository repository;
    @Autowired
    private SecurityConfig securityConfig;

    @ApiOperation(value = "Faz a inserção de um novo login na base de dados.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma confirmação de que um novo login foi salvo com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    public Sessao logar(@RequestBody Login login) {

        UserModel userModel = repository.findByUsername(login.getUsername());

        if (userModel != null) {
            boolean passwordOK = encoder.matches(login.getPassword(), userModel.getPassword());

            if (!passwordOK) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }

            // Envio de um objeto Sessão para retornar mais informações do usuário.
            Sessao sessao = new Sessao();
            sessao.setLogin(userModel.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(userModel.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));

            return sessao;

        } else {

            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
