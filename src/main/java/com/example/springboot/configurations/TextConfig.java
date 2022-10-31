package com.example.springboot.configurations;

import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TextConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        productRepository.deleteAll();

        ProductModel Product1 = new ProductModel(null, "Notebook Apple 7", 9000.00);
        ProductModel Product2 = new ProductModel(null, "Samsung S10", 4000.00);
        ProductModel Product3 = new ProductModel(null, "Tablet Lg", 1400.00);
        ProductModel Product4 = new ProductModel(null, "Iphone 11 ATUALIZADO", 6500.00);
        ProductModel Product5 = new ProductModel(null, "Desktop Samsung HD 500G - 8G memória", 4000.00);

        productRepository.saveAll(Arrays.asList(Product1, Product2, Product3, Product4, Product5));
    }
}
