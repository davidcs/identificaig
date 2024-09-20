package br.com.identificaig.Idetificaig.dtos;

import java.util.UUID;

import br.com.identificaig.Idetificaig.models.TipoIndicacao;
import br.com.identificaig.Idetificaig.models.TipoProduto;

public record PinDTO( 
		 UUID UUID,
		    
	    //Identificação Geografica
	     String nome,
	     String descricao,
	     TipoIndicacao tipoIndicacao,
	     String cadernoEspecificacoesTecnicas,
	    
	    //Area geografica
	     double latitude,
	     double longitude,

	    //Produto
	     String nomeProduto,
	     TipoProduto tipoProduto,
	     String especificacoesCaracteristicas,

	    //Estruta
	     String estruturaControle,
	     double nivelMaturidade,

	    //Representante
	     String representante,
	     String cpfCnpj,
	     String telefone,
	     String endereco,
	     String cep,
	     String email,
	     String cidade,
	     String estado,
	     String procurador,
	     String observacoes
		) {
}
