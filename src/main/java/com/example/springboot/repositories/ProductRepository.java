package com.example.springboot.repositories;

import com.example.springboot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * ‘Interface’ responsável por administrar as transações com o banco de dados e escolher
 * o melhor estereótipo a ser utilizado pelo Spring.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
