package com.br.api.provadezembro2021.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_fonecedores")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idFornecedor;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "fornecedores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdutoModel> produtos = new ArrayList<>();

    public FornecedorModel(FornecedorModel entity){
        idFornecedor = entity.getIdFornecedor();
        nome = entity.getNome();
        produtos = entity.getProdutos().stream().map(produtoModel -> new ProdutoModel(produtoModel)).collect(Collectors.toList());
    }
}
