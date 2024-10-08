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
@Table(name = "falha")
@Entity
public class Falha {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Definindo a coluna 'maquinaId' e relacionando-a corretamente com a entidade Maquina
    @ManyToOne
    @JoinColumn(name = "maquinaId", referencedColumnName = "id", nullable = false)
    private Maquina maquina;

    @Column(length = 155 , nullable = false)
    private String dataFalha;

    @Column(length = 155 , nullable = false)
    private String problema;

    @Column(length = 155 , nullable = false)
    private String prioridade;

    // Definindo a coluna 'tecnicoId' e relacionando-a corretamente com a entidade Tecnico
    @ManyToOne
    @JoinColumn(name = "tecnicoId", referencedColumnName = "id", nullable = false)
    private Tecnico tecnico;
}
