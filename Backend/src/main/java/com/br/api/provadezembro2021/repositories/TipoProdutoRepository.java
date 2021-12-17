package com.br.api.provadezembro2021.repositories;

import com.br.api.provadezembro2021.models.ProdutoModel;
import com.br.api.provadezembro2021.models.TipoProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TipoProdutoRepository extends JpaRepository<TipoProdutoModel, Long> {
    Optional<TipoProdutoModel> findByNome(String nome);
}
