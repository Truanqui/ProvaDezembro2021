package com.br.api.provadezembro2021.repositories;

import com.br.api.provadezembro2021.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNome(String nome);
}
