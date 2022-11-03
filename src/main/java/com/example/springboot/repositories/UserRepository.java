package com.example.springboot.repositories;

import com.example.springboot.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * ‘Interface’ responsável por administrar as transações com o banco de dados e escolher
 * o melhor estereótipo a ser utilizado pelo Spring.
 */
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Query("select e from UserModel e join fetch e.roles where e.username=(:username)")
    UserModel findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}
