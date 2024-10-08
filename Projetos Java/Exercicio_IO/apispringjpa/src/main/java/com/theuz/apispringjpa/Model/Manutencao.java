package com.theuz.apispringjpa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "manutencao")
@Entity
public class Manutencao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Definindo a coluna 'maquinaId' e relacionando-a corretamente com a entidade Maquina
    @ManyToOne
    @JoinColumn(name = "maquinaId", referencedColumnName = "id", nullable = false)
    private Maquina maquina;

    @Column(length = 155 , nullable = false)
    private String dataManutencao;

    @Column(length = 155 , nullable = false)
    private String tipo;

    @Column(length = 155 , nullable = false)
    private String pecasTrocadas;

    @Column(length = 155 , nullable = false)
    private String tempoParado;

    // Definindo a coluna 'tecnicoId' e relacionando-a corretamente com a entidade Tecnico
    @ManyToOne
    @JoinColumn(name = "tecnicoId", referencedColumnName = "id", nullable = false)
    private Tecnico tecnico;

    @Column(length = 155 , nullable = false)
    private String observacoes;
}
