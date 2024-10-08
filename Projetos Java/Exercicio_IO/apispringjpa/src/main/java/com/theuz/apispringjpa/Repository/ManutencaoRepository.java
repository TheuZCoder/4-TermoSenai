package com.theuz.apispringjpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theuz.apispringjpa.Model.Manutencao;

public interface ManutencaoRepository  extends JpaRepository<Manutencao, Integer> {
    
    List<Manutencao> findByMaquinaId(Integer maquinaId);
    
    List<Manutencao> findByTecnicoId(Integer tecnicoId);    
}
