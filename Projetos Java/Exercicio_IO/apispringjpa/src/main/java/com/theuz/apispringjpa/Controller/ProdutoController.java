package com.theuz.apispringjpa.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theuz.apispringjpa.Model.Produto;
import com.theuz.apispringjpa.Service.ProdutoService;


import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Optional<Produto> produto = produtoService.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping 
    public Produto save(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(
            @PathVariable Integer id,
            @RequestBody Produto produtoDetails) {
        
        Optional<Produto> produtoOptional = produtoService.findById(id);

        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setNome(produtoDetails.getNome());
            produto.setPreco(produtoDetails.getPreco());
            produto.setQuantidade(produtoDetails.getQuantidade());
            
            final Produto updatedProduto = produtoService.save(produto);
            return ResponseEntity.ok(updatedProduto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
