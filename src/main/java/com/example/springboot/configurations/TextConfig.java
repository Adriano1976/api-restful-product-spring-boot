package com.example.springboot.configurations;

import com.example.springboot.models.ProdutoModel;
import com.example.springboot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class TextConfig implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public void run(String... args) throws Exception {

        ProdutoModel produto1 = new ProdutoModel(null, "Notebook Apple 7", 9000.00);
        ProdutoModel produto2 = new ProdutoModel(null, "Samsung S10", 4000.00);
        ProdutoModel produto3 = new ProdutoModel(null, "Tablet Lg", 1400.00);
        ProdutoModel produto4 = new ProdutoModel(null, "Iphone 11 ATUALIZADO", 6500.00);
        ProdutoModel produto5 = new ProdutoModel(null, "Desktop Samsung HD 500G - 8G memória", 4000.00);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
    }
}
