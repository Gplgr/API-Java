package rest.api.service;

import java.util.List;

import jakarta.transaction.Transactional;
import rest.api.model.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Transactional
@Service
public class ProdutoImp {
	@Autowired
    private ProdutoRepository repo;

	public List<Produto> listAll() {
        return repo.findAll();
    }
     
    public void save(Produto produto) {
        repo.save(produto);
    }
     
    public Produto get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}