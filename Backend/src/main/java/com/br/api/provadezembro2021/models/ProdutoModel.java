package com.br.api.provadezembro2021.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProduto;
    private String nome;
    private int estoqueProduto;
    private Double precoVendaProduto;
    private Double precoCompraProduto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idTipoProduto")
    private TipoProdutoModel tipoProdutos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFornecedor")
    private FornecedorModel fornecedores;

    public ProdutoModel(ProdutoModel entity){
        idProduto = entity.getIdProduto();
        nome = entity.getNome();
        estoqueProduto = entity.getEstoqueProduto();
        precoVendaProduto = entity.getPrecoVendaProduto();
        precoCompraProduto = entity.getPrecoCompraProduto();
        tipoProdutos = entity.getTipoProdutos();
        fornecedores = entity.getFornecedores();
    }
}
