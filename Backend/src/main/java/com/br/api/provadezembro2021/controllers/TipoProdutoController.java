package com.br.api.provadezembro2021.controllers;

import com.br.api.provadezembro2021.models.TipoProdutoModel;
import com.br.api.provadezembro2021.services.TipoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/tipo-produtos")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService service;

    @GetMapping
    public ResponseEntity<List<TipoProdutoModel>> findAll(){
        List<TipoProdutoModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<TipoProdutoModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<TipoProdutoModel> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<TipoProdutoModel> save(@RequestBody TipoProdutoModel tipoProdutoModel) throws Exception {
        return new ResponseEntity<>(service.insert(tipoProdutoModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TipoProdutoModel> update(@PathVariable Long id, @RequestBody TipoProdutoModel update){
        return ResponseEntity.ok(service.update(id, update));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Tipo produto" + id + "deletado!");
    }

}
