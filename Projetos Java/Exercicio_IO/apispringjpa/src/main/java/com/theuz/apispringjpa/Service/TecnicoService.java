package com.theuz.apispringjpa.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theuz.apispringjpa.Model.Tecnico;
import com.theuz.apispringjpa.Repository.TecnicoRepository;

@Service
public class TecnicoService {
    
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Optional<Tecnico> findById(Integer id) {
        return tecnicoRepository.findById(id);
    }

    public Tecnico save(Tecnico usuario) {
        return tecnicoRepository.save(usuario);
    }

    public void deleteById(Integer id) {
        tecnicoRepository.deleteById(id);
    }
}
