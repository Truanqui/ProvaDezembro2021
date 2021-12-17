package com.br.api.provadezembro2021.repositories;

import com.br.api.provadezembro2021.models.FornecedorModel;
import com.br.api.provadezembro2021.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
    Optional<FornecedorModel> findByNome(String nome);
}
