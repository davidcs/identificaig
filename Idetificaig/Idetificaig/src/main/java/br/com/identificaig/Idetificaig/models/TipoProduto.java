package br.com.identificaig.Idetificaig.models;

public enum TipoProduto {
	PRODUTO("Produto"),
	SERVICO("Serviço");

    private final String descricao;

    TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}