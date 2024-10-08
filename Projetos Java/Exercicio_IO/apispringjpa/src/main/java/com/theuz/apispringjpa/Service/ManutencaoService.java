package com.theuz.apispringjpa.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theuz.apispringjpa.Model.Manutencao;
import com.theuz.apispringjpa.Repository.ManutencaoRepository;

@Service
public class ManutencaoService {
    
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public List<Manutencao> findAll() {
        return manutencaoRepository.findAll();
    }

    public Optional<Manutencao> findById(Integer id) {
        return manutencaoRepository.findById(id);
    }

    public Manutencao save(Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    public void deleteById(Integer id) {
        manutencaoRepository.deleteById(id);
    }

}
