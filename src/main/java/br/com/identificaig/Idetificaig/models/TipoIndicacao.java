package br.com.identificaig.Idetificaig.models;

public enum TipoIndicacao {
	IDENTIFICACAO_PROCEDENCIA("Identificação Procedencia"),
    DENOMINACAO_ORIGEM("Denominação de Origem");

    private final String descricao;

    TipoIndicacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}