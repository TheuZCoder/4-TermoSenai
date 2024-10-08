package com.theuz.apispringjpa.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManutencaoDTO {
    private Integer maquinaId;   // Apenas o ID da máquina
    private String dataManutencao;
    private String tipo;
    private String pecasTrocadas;
    private String tempoParado;
    private Integer tecnicoId;   // Apenas o ID do técnico
    private String observacoes;
}
