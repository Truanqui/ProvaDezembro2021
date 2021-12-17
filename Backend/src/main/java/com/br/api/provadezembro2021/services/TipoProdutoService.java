package com.br.api.provadezembro2021.services;

import com.br.api.provadezembro2021.exceptions.ProdutoAlreadyExistsException;
import com.br.api.provadezembro2021.exceptions.ProdutoNotFoundException;
import com.br.api.provadezembro2021.models.TipoProdutoModel;
import com.br.api.provadezembro2021.repositories.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoProdutoService {

    @Autowired
    private TipoProdutoRepository repository;

    public List<TipoProdutoModel> findAll() {
        List<TipoProdutoModel> result = repository.findAll();
        return result.stream().map(x -> new TipoProdutoModel(x)).collect(Collectors.toList());
    }

    public TipoProdutoModel insert(TipoProdutoModel tipoProdutoModel){

        Optional<TipoProdutoModel> tipoProdutoVerify = repository.findByNome(tipoProdutoModel.getNome());
        if (tipoProdutoVerify.isPresent()) {
            throw new ProdutoAlreadyExistsException("Tipo produto já existe!");
        }

        TipoProdutoModel unit = new TipoProdutoModel();
        unit.setIdTipoProduto(tipoProdutoModel.getIdTipoProduto());
        unit.setNome(tipoProdutoModel.getNome());

        unit = repository.save(unit);

        return unit;
    }

    public TipoProdutoModel findById(Long id){
        Optional<TipoProdutoModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ProdutoNotFoundException("Tipo produto não encontrado. Por favor tente novamente."));
    }

    public TipoProdutoModel findByNome(String nome) {
        Optional<TipoProdutoModel> result = repository.findByNome(nome);
        return result.orElseThrow(() -> new ProdutoNotFoundException("Tipo produto não encontrado. Por favor tente novamente."));
    }

    public void deleteById(Long id){
        repository.delete(findById(id));
    }

    public TipoProdutoModel update(Long id, TipoProdutoModel update){
        TipoProdutoModel updated = findById(id);

        updated.setNome(update.getNome());

        repository.save(updated);

        return updated;
    }
}
