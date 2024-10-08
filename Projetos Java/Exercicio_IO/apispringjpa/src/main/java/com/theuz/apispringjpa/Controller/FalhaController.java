package com.theuz.apispringjpa.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theuz.apispringjpa.DTO.FalhaDTO;
import com.theuz.apispringjpa.Model.Falha;
import com.theuz.apispringjpa.Model.Maquina;
import com.theuz.apispringjpa.Model.Tecnico;
import com.theuz.apispringjpa.Service.FalhaService;
import com.theuz.apispringjpa.Service.MaquinaService;
import com.theuz.apispringjpa.Service.TecnicoService;


import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/falha")

public class FalhaController {

    @Autowired
    private FalhaService falhaService;

    @Autowired
    private MaquinaService maquinaService;

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public List<Falha> findAll() {
        return falhaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Falha> findById(@PathVariable Integer id) {
        Optional<Falha> falha = falhaService.findById(id);
        if (falha.isPresent()) {
            return ResponseEntity.ok(falha.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Método para salvar a falha usando apenas o ID da máquina e técnico
@PostMapping
public ResponseEntity<Falha> save(@RequestBody FalhaDTO falhaDTO) {
    Optional<Maquina> maquinaOptional = maquinaService.findById(falhaDTO.getMaquinaId());
    Optional<Tecnico> tecnicoOptional = tecnicoService.findById(falhaDTO.getTecnicoId());

    if (maquinaOptional.isPresent() && tecnicoOptional.isPresent()) {
        Maquina maquina = maquinaOptional.get();
        Tecnico tecnico = tecnicoOptional.get();

        Falha falha = new Falha();
        falha.setMaquina(maquina);
        falha.setDataFalha(falhaDTO.getDataFalha());
        falha.setProblema(falhaDTO.getProblema());
        falha.setPrioridade(falhaDTO.getPrioridade());
        falha.setTecnico(tecnico);

        Falha savedFalha = falhaService.save(falha);
        return ResponseEntity.ok(savedFalha);
    } else {
        return ResponseEntity.badRequest().build();
    }
}

// Método para atualizar a falha usando apenas o ID da máquina e técnico
@PutMapping("/{id}")
public ResponseEntity<Falha> updateFalha(
        @PathVariable Integer id,
        @RequestBody FalhaDTO falhaDTO) {

    Optional<Falha> falhaOptional = falhaService.findById(id);
    Optional<Maquina> maquinaOptional = maquinaService.findById(falhaDTO.getMaquinaId());
    Optional<Tecnico> tecnicoOptional = tecnicoService.findById(falhaDTO.getTecnicoId());

    if (falhaOptional.isPresent() && maquinaOptional.isPresent() && tecnicoOptional.isPresent()) {
        Falha falha = falhaOptional.get();
        Maquina maquina = maquinaOptional.get();
        Tecnico tecnico = tecnicoOptional.get();

        falha.setMaquina(maquina);
        falha.setDataFalha(falhaDTO.getDataFalha());
        falha.setProblema(falhaDTO.getProblema());
        falha.setPrioridade(falhaDTO.getPrioridade());
        falha.setTecnico(tecnico);

        Falha updatedFalha = falhaService.save(falha);
        return ResponseEntity.ok(updatedFalha);
    } else {
        return ResponseEntity.notFound().build();
    }
}


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Falha> falha = falhaService.findById(id);
        if (falha.isPresent()) {
            falhaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
