package com.theuz.apispringjpa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "maquinas")
@Entity
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45 , nullable = false)
    private String codigo;

    @Column(length = 45 , nullable = false)
    private String nome;

    @Column(length = 155 , nullable = false)
    private String modelo;

    @Column(length = 155 , nullable = false)
    private String fabricante;

    @Column(length = 155 , nullable = false)
    private String dataAquisicao;

    @Column(length = 155 , nullable = false)
    private Integer tempoVidaEstimado;

    @Column(length = 155 , nullable = false)
    private String localizacao;

    @Column(length = 155 , nullable = false)
    private String detalhes;

    @Column(length = 155 , nullable = false)
    private String manual;
    
}
