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
    public Produto getNoteById(@PathVariable(value = "id") Long id) {
    	return produtoRepository.findById(id).orElseThrow();	
    }

    //POST de um elemento
    @PostMapping("/criar")
    public Produto createNote(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    
    // PUT para alterar um elemento
    @PutMapping("/produto/{id}")
    public Produto updateNote(@PathVariable(value = "id") Long id, @Valid @RequestBody Produto atualizado) {
    		Produto produto = produtoRepository.findById(id).orElseThrow();
    		produto.setValor(atualizado.getValor());
    		produto.setQuantidade(atualizado.getQuantidade());
    		Produto prodAtualizado = produtoRepository.save(produto);
   			return prodAtualizado;
    }
    // DELETE de um produto
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();

        produtoRepository.delete(produto);

        return ResponseEntity.ok().build();
    }
}