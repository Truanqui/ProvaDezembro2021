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
@Table(name = "tab_tipo_produtos)")
public class TipoProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idTipoProduto;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoProdutos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdutoModel> produtos = new ArrayList<>();

    public TipoProdutoModel(TipoProdutoModel entity){
        idTipoProduto = entity.getIdTipoProduto();
        nome = entity.getNome();
        produtos = entity.getProdutos().stream().map(produtoModel -> new ProdutoModel(produtoModel)).collect(Collectors.toList());
    }
}
