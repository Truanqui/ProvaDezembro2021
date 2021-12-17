package com.br.api.provadezembro2021.services;

import com.br.api.provadezembro2021.exceptions.ProdutoAlreadyExistsException;
import com.br.api.provadezembro2021.exceptions.ProdutoNotFoundException;
import com.br.api.provadezembro2021.models.FornecedorModel;
import com.br.api.provadezembro2021.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ForncedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorModel> findAll(){
        List<FornecedorModel> result = repository.findAll();
        return result.stream().map(x -> new FornecedorModel(x)).collect(Collectors.toList());
    }

    public FornecedorModel insert(FornecedorModel fornecedorModel){

        Optional<FornecedorModel> fornecedorVerify = repository.findByNome(fornecedorModel.getNome());
        if(fornecedorVerify.isPresent()) {
            throw new ProdutoAlreadyExistsException("Fornecedor já existe!");
        }
        FornecedorModel unit = new FornecedorModel();
        unit.setIdFornecedor(fornecedorModel.getIdFornecedor());
        unit.setNome(fornecedorModel.getNome());

        unit = repository.save(unit);

        return unit;
    }

    public FornecedorModel findById(Long id){
        Optional<FornecedorModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ProdutoNotFoundException("Fornecedor não encontrado. Por favor tente novamente."));
    }

    public FornecedorModel findByNome(String nome) {
        Optional<FornecedorModel> result = repository.findByNome(nome);
        return result.orElseThrow(() -> new ProdutoNotFoundException("Fornecedor não econtrado. Por favor tente novamente."));
    }

    public void deleteById(Long id){
        repository.delete(findById(id));
    }

    public FornecedorModel update(Long id, FornecedorModel update){
        FornecedorModel updated = findById(id);

        updated.setNome(update.getNome());

        repository.save(updated);

        return updated;
    }
}
