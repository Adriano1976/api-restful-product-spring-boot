package com.example.springboot.controllers;

import com.example.springboot.models.ProdutoModel;
import com.example.springboot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Classe responsável em controlar e criar endpoints REST e mostrar ao Spring que tal classe será um bean
 * gerenciado por ele através da IoC/ID.
 */
@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    /**
     * Método resonsável em buscar a listagem de produtos disponível na base de dados.
     *
     * @return Retorna uma lista com todos os produtos encontrados na base de dados, com um status.
     */
    @GetMapping(value = "/produtos")
    public ResponseEntity<List<ProdutoModel>> getAllProdutos() {
        List<ProdutoModel> produtoModelList = produtoRepository.findAll();
        if (produtoModelList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            for (ProdutoModel produto : produtoModelList) {
                long id = produto.getIdProduto();
                /*
                 * Método linkTo() - ConstruirIrá uma url conforme o controller.
                 * Método methodOn() - Faz o mapeamento do método de destino da chamada.
                 * withSelfRel() e withRel() - Criam um autolink conforme a relação.
                 * Cada 'ligação' criado deve ser inserido no produto através do método add()
                 * */
                produto.add(linkTo(methodOn(ProdutoController.class).getOneProduto(id)).withSelfRel());
            }
            return new ResponseEntity<>(produtoModelList, HttpStatus.OK);
        }
    }

    /**
     * Método responsável em buscar um produto específico atravês do ‘id’ recebido e passado para o método findById.
     *
     * @param id Objeto responsável em receber o ‘id’ do produto encontrado.
     * @return Retorna os dados de um produto encontrado conforme o ‘id’, com o status.
     */
    @GetMapping(value = "/produto/{id}")
    public ResponseEntity<ProdutoModel> getOneProduto(@PathVariable(value = "id") long id) {
        Optional<ProdutoModel> produtoModelOptional = produtoRepository.findById(id);

        if (produtoModelOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            /*
             * Método linkTo() - ConstruirIrá uma url conforme o controller.
             * Método methodOn() - Faz o mapeamento do método de destino da chamada.
             * withSelfRel() e withRel() - Criam um autolink conforme a relação.
             * Cada 'ligação' criado deve ser inserido no produto através do método add()
             * */
            produtoModelOptional.get().add(linkTo(methodOn(ProdutoController.class).getAllProdutos()).withRel("Lista de Produtos"));
            return new ResponseEntity<>(produtoModelOptional.get(), HttpStatus.OK);
        }
    }

    /**
     * Método responsável por salvar os produtos na base de dados, com o auxílio do método save do JPA.
     * Caso a persistência ocorra corretamente no banco, será retornado uma mensagem.
     *
     * @param produtoModel Objeto responsável em receber e manipular os dados do novo produto para a base de dados.
     * @return Retorna a mensagem com o código 202 se os dados foram salvos corretamente.
     */
    @PostMapping(value = "/produtos")
    public ResponseEntity<ProdutoModel> saveProduto(@RequestBody @Validated ProdutoModel produtoModel) {
        return new ResponseEntity<>(produtoRepository.save(produtoModel), HttpStatus.CREATED);
    }

    /**
     * Método responsável em deletar um conjunto de dados do produto através do método HTTP DELETE, passando o ‘id’ do
     * produto a der deletado por meio do método delete do JPA delete.
     *
     * @param id Objeto responsável em receber o número do id do produto a ser apagodo.
     * @return Retorna o código 200 como sendo OK caso a deleção ocorra corretamente.
     */
    @DeleteMapping(value = "/produtos/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable(value = "id") long id) {
        Optional<ProdutoModel> produtoModelOptional = produtoRepository.findById(id);

        if (produtoModelOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produtoRepository.delete(produtoModelOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * Método responsável em atualizar um determinado produto, por meio do ‘id’ do mesmo para ser feito a alteração
     * do produto já existente por meio do método save.
     *
     * @param id           Objeto responsável em receber e manipular o ‘id’ do produto a ser modificado.
     * @param produtoModel Objeto responsável em receber e manipular o produto já identificado.
     * @return Retorna o código 200 como sendo OK caso a alteração ocorra corretamente.
     */
    @PutMapping(value = "/produtos/{id}")
    public ResponseEntity<ProdutoModel> updateProduto(@PathVariable(value = "id") long id, @RequestBody @Validated ProdutoModel produtoModel) {
        Optional<ProdutoModel> produtoModelOptional = produtoRepository.findById(id);

        if (produtoModelOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produtoModel.setIdProduto(produtoModelOptional.get().getIdProduto());
            return new ResponseEntity<>(produtoRepository.save(produtoModel), HttpStatus.OK);
        }
    }
}
