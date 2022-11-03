package com.example.springboot.service;

import com.example.springboot.models.UserModel;
import com.example.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Classe responsável por conter a regra de negócio.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(UserModel userModel) {
        String pass = userModel.getPassword();

        // Criptografando antes de salvar no banco.
        userModel.setPassword(passwordEncoder.encode(pass));
        userRepository.save(userModel);
    }
}
