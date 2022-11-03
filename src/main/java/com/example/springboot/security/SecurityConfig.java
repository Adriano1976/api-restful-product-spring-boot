package com.example.springboot.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Classe responsável por representar o componente que receberá as propriedades e credenciais do token via
 * application.propoerties.
 */
@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {

    public static String PREFIX; // Profixo do token.
    public static String KEY; // A sua chave privada.
    public static Long EXPIRATION; // Tempo de expiração do token.

    public void setPrefix(String prefix){
        PREFIX = prefix;
    }
    public void setKey(String key){
        KEY = key;
    }
    public void setExpiration(Long expiration){
        EXPIRATION = expiration;
    }
}
