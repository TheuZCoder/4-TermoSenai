package com.theuz.apispringjpa.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FalhaDTO {
    private Integer id;                 // ID da falha
    private Integer maquinaId;          // ID da máquina relacionada
    private String dataFalha;           // Data da falha
    private String problema;             // Descrição do problema
    private String prioridade;           // Prioridade da falha
    private Integer tecnicoId;          // ID do técnico responsável
}
