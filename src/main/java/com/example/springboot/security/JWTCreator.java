package com.example.springboot.security;

import io.jsonwebtoken.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por gerar o Token baseado no Objeto e/ou instanciar o Objeto JWT com base no Token
 * e vice-versa.
 */
public class JWTCreator {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    public static String create(String prefix, String key, JWTObject jwtObject) {
        String token = Jwts.builder()
                .setSubject(jwtObject.getSubject())
                .setIssuedAt(jwtObject.getIssuedAt())
                .setExpiration(jwtObject.getExpiration())
                .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles()))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return prefix + " " + token;
    }

    public static JWTObject create(String token, String prefix, String key)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {

        JWTObject jwtObject = new JWTObject();
        token = token.replace(prefix, "");
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        jwtObject.setSubject(claims.getSubject());
        jwtObject.setExpiration(claims.getExpiration());
        jwtObject.setIssuedAt(claims.getIssuedAt());
        jwtObject.setRoles((List<String>) claims.get(ROLES_AUTHORITIES));

        return jwtObject;
    }

    private static List<String> checkRoles(List<String> roles) {
        return roles
                .stream()
                .map(s -> "ROLE_".concat(s.replaceAll("ROLE_", "")))
                .collect(Collectors.toList());
    }
}
