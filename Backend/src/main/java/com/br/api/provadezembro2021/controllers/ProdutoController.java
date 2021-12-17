package com.br.api.provadezembro2021.controllers;

import com.br.api.provadezembro2021.models.ProdutoModel;
import com.br.api.provadezembro2021.repositories.ProdutoRepository;
import com.br.api.provadezembro2021.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ProdutoModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<ProdutoModel> findByNome(@PathVariable String nome){
        return ResponseEntity.ok(service.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> save(@RequestBody ProdutoModel produtoModel) throws Exception {
        return  new ResponseEntity<>(service.insert(produtoModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProdutoModel> update(@PathVariable Long id, @RequestBody ProdutoModel update){
        return ResponseEntity.ok(service.update(id, update));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Produto" + id + "deletado!");
    }

}
