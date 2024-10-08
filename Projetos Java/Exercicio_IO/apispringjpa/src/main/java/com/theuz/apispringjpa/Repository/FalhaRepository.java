package com.theuz.apispringjpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theuz.apispringjpa.Model.Falha;

public interface FalhaRepository extends JpaRepository<Falha, Integer> {
    
    List<Falha> findByMaquinaId(Integer maquinaId);
    
    List<Falha> findByTecnicoId(Integer tecnicoId);   
}
