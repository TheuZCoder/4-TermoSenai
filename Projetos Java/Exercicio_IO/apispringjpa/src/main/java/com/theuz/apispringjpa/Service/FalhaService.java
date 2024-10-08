package com.theuz.apispringjpa.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theuz.apispringjpa.Model.Falha;
import com.theuz.apispringjpa.Repository.FalhaRepository;

@Service
public class FalhaService {
    
    @Autowired
    private FalhaRepository falhaRepository;

    public List<Falha> findAll() {
        return falhaRepository.findAll();
    }

    public Optional<Falha> findById(Integer id) {
        return falhaRepository.findById(id);
    }

    public Falha save(Falha falha) {
        return falhaRepository.save(falha);
    }

    public void deleteById(Integer id) {
        falhaRepository.deleteById(id);
    }
}
