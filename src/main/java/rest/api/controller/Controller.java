package rest.api.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import rest.api.model.Produto;
import rest.api.service.ProdutoRepository;
 
@RestController
public class Controller {
 
    @Autowired
    ProdutoRepository produtoRepository;
     
    // GET para todos os elementos
    @GetMapping("/listar")
    public List<Produto> list() {
        return produtoRepository.findAll();
    }
    
    //GET para um elemento especíico
    @GetMapping("/produto/{id}")
    public Produto getProdutoById(@PathVariable(value = "id") Integer id) {
    	Long idlong = Long.valueOf(id);
    	return produtoRepository.findById(idlong).orElseThrow();	
    }

    //POST de um elemento
    @PostMapping("/criar")
    public Produto createProduto(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    
    // PUT para alterar um elemento
    @PutMapping("/produto/{id}")
    public Produto updateProduto(@PathVariable(value = "id") Integer id, @Valid @RequestBody Produto atualizado) {
    	Long idlong = Long.valueOf(id);
    	Produto produto = produtoRepository.findById(idlong).orElseThrow();
    	produto.setValor(atualizado.getValor());
    	produto.setQuantidade(atualizado.getQuantidade());
    	Produto prodAtualizado = produtoRepository.save(produto);
   		return prodAtualizado;
    }
    // DELETE de um produto
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable(value = "id") Integer id) {
    	Long idlong = Long.valueOf(id);
        Produto produto = produtoRepository.findById(idlong).orElseThrow();

        produtoRepository.delete(produto);

        return ResponseEntity.ok().build();
    }
}