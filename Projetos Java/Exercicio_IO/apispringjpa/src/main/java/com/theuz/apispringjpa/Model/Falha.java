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

    @Column(length = 45 , nullable = false)
    private Integer maquinaId;

    @ManyToOne
    @JoinColumn(name = "maquina_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Maquina maquina;

    @Column(length = 155 , nullable = false)
    private String dataFalha;

    @Column(length = 155 , nullable = false)
    private String problema;

    @Column(length = 155 , nullable = false)
    private String prioridade;

    @Column(length = 155 , nullable = false)
    private Integer tecnicoId;

    @ManyToOne
    @JoinColumn(name = "tecnico_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Tecnico tecnico;
}
