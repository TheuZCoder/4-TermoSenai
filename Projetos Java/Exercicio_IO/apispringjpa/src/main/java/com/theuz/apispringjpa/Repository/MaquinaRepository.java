package com.theuz.apispringjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theuz.apispringjpa.Model.Maquina;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Integer>{
    
}
