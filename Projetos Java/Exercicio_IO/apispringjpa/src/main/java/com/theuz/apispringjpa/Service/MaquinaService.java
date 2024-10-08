package com.theuz.apispringjpa.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theuz.apispringjpa.Model.Maquina;
import com.theuz.apispringjpa.Repository.MaquinaRepository;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

    public List<Maquina> findAll() {
        return maquinaRepository.findAll();
    }

    public Optional<Maquina> findById(Integer id) {
        return maquinaRepository.findById(id);
    }

    public Maquina save(Maquina maquina) {
        return maquinaRepository.save(maquina);
    }

    public void deleteById(Integer id) {
        maquinaRepository.deleteById(id);
    }
}
