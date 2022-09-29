package com.example.springboot.controllers;

import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Classe responsável em controlar e criar endpoints REST e mostrar ao Spring que tal classe será um bean
 * gerenciado por ele através da IoC/ID.
 */
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    /**
     * Método resonsável em buscar a listagem de Products disponível na base de dados usando outros métodos.
     * Método linkTo() - ConstruirIrá uma url conforme o controller.
     * Método methodOn() - Faz o mapeamento do método de destino da chamada.
     * withSelfRel() e withRel() - Criam um autolink conforme a relação.
     * Cada 'ligação' criado deve ser inserido no Product através do método add()
     *
     * @return Retorna uma lista com todos os Products encontrados na base de dados, com um status.
     */
    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {

        List<ProductModel> productList = productRepository.findAll();

        if (!productList.isEmpty()) {
            for (ProductModel product : productList) {
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
            }
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    /**
     * Método responsável em buscar um Product específico atravês do ‘id’ recebido e passado para o método findById.
     * Método linkTo() - ConstruirIrá uma url conforme o controller.
     * Método methodOn() - Faz o mapeamento do método de destino da chamada.
     * withSelfRel() e withRel() - Criam um autolink conforme a relação.
     * Cada 'ligação' criado deve ser inserido no Product através do método add()
     *
     * @param id Objeto responsável em receber o ‘id’ do Product encontrado.
     * @return Retorna os dados de um Product encontrado conforme o ‘id’, com o status.
     */
    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductModel> getOneProduct(@PathVariable(value = "id") UUID id) {

        Optional<ProductModel> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productOptional.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Lista de Products"));
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    /**
     * Método responsável por salvar os Products na base de dados, com o auxílio do método save do JPA.
     * Caso a persistência ocorra corretamente no banco, será retornado uma mensagem.
     *
     * @param productModel Objeto responsável em receber e manipular os dados do novo Product para a base de dados.
     * @return Retorna a mensagem com o código 202 se os dados foram salvos corretamente.
     */
    @PostMapping(value = "/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Validated ProductModel productModel) {
        return new ResponseEntity<>(productRepository.save(productModel), HttpStatus.CREATED);
    }

    /**
     * Método responsável em deletar um conjunto de dados do Product através do método HTTP DELETE, passando o ‘id’ do
     * product a ser deletado por meio do método delete do JPA delete.
     *
     * @param id Objeto responsável em receber o número do id do Product a ser apagodo.
     * @return Retorna o código 200 como sendo OK caso a deleção ocorra corretamente.
     */
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> ProductOptional = productRepository.findById(id);

        if (ProductOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productRepository.delete(ProductOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * Método responsável em atualizar um determinado Product, por meio do ‘id’ do mesmo para ser feito a alteração
     * do Product já existente por meio do método save.
     *
     * @param id           Objeto responsável em receber e manipular o ‘id’ do Product a ser modificado.
     * @param productModel Objeto responsável em receber e manipular o Product já identificado.
     * @return Retorna o código 200 como sendo OK caso a alteração ocorra corretamente.
     */
    @PutMapping(value = "/products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Validated ProductModel productModel) {
        Optional<ProductModel> ProductOptional = productRepository.findById(id);

        if (ProductOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productModel.setIdProduct(ProductOptional.get().getIdProduct());
            return new ResponseEntity<>(productRepository.save(productModel), HttpStatus.OK);
        }
    }
}
