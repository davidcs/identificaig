package br.com.identificaig.Idetificaig.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "pins")
public class Pin {
    @Id
    @Column(name = "id", columnDefinition = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private UUID id;
 
    //Identificação Geografica
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoIndicacao tipoIndicacao;
    @Column(columnDefinition = "TEXT")
    private String cadernoEspecificacoesTecnicas;
    
    //Area geografica
    private double latitude;
    private double longitude;

    //Produto
    private String nomeProduto;
    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;
    @Column(columnDefinition = "TEXT")
    private String especificacoesCaracteristicas;

    //Estruta
    private String estruturaControle;
    private double nivelMaturidade;

    //Representante
    private String representante;
    private String cpfCnpj;
    private String telefone;
    private String endereco;
    private String cep;
    @Email
    private String email;
    private String cidade;
    private String estado;
    private String procurador;
    @Column(columnDefinition = "TEXT")
    private String observacoes;
    
}
