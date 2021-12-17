package com.br.api.provadezembro2021.services;

import com.br.api.provadezembro2021.exceptions.ProdutoAlreadyExistsException;
import com.br.api.provadezembro2021.exceptions.ProdutoNotFoundException;
import com.br.api.provadezembro2021.models.ProdutoModel;
import com.br.api.provadezembro2021.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> findAll() {
        List<ProdutoModel> result = repository.findAll();
        return  result.stream().map(x -> new ProdutoModel(x)).collect(Collectors.toList());
    }

    public ProdutoModel insert(ProdutoModel produtoModel){
        Optional<ProdutoModel> produtoVerify = repository.findByNome(produtoModel.getNome());
        if (produtoVerify.isPresent()) {
            throw new ProdutoAlreadyExistsException("Produto já existe!");
        }

        ProdutoModel unit = new ProdutoModel();
        unit.setIdProduto(produtoModel.getIdProduto());
        unit.setNome(produtoModel.getNome());
        unit.setEstoqueProduto(produtoModel.getEstoqueProduto());
        unit.setPrecoCompraProduto(produtoModel.getPrecoCompraProduto());
        unit.setPrecoVendaProduto(produtoModel.getPrecoVendaProduto());
        unit.setTipoProdutos(produtoModel.getTipoProdutos());
        unit.setFornecedores(produtoModel.getFornecedores());

        unit = repository.save(unit);

        return unit;

    }

    public ProdutoModel findById(Long id){
        Optional<ProdutoModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado. Por favor tente novamente."));
    }

    public ProdutoModel findByNome(String nome) {
        Optional<ProdutoModel> result = repository.findByNome(nome);
        return result.orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado. Por favor tente novamente."));
    }

    public void deleteById(Long id){
        repository.delete(findById(id));
    }

    public ProdutoModel update(Long id, ProdutoModel update){
        ProdutoModel updated = findById(id);

        updated.setNome(update.getNome());
        updated.setEstoqueProduto(update.getEstoqueProduto());
        updated.setPrecoCompraProduto(update.getPrecoCompraProduto());
        updated.setPrecoVendaProduto(update.getPrecoVendaProduto());
        updated.setTipoProdutos(update.getTipoProdutos());
        updated.setFornecedores(update.getFornecedores());

        repository.save(updated);

        return updated;

    }

}
