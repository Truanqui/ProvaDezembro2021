package com.br.api.provadezembro2021.controllers;

import com.br.api.provadezembro2021.models.FornecedorModel;
import com.br.api.provadezembro2021.models.ProdutoModel;
import com.br.api.provadezembro2021.services.ForncedorService;
import com.br.api.provadezembro2021.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController {
    @Autowired
    private ForncedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<FornecedorModel> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<FornecedorModel> findByNome(@PathVariable String nome){
        return ResponseEntity.ok(service.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> save(@RequestBody FornecedorModel fornecedorModel) throws Exception {
        return new ResponseEntity<>(service.insert(fornecedorModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FornecedorModel> update(@PathVariable Long id, @RequestBody FornecedorModel update){
        return ResponseEntity.ok(service.update(id, update));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Fornecedor" + id + "deletado!");
    }
}
