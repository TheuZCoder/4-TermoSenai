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

import com.theuz.apispringjpa.Model.Falha;
import com.theuz.apispringjpa.Service.FalhaService;


import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/falha")

public class FalhaController {

    @Autowired
    private FalhaService falhaService;

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

    @PostMapping
    public Falha save(@RequestBody Falha falha) {
        return falhaService.save(falha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Falha> updateFalha(
            @PathVariable Integer id,
            @RequestBody Falha falhaDetails) {

        Optional<Falha> falhaOptional = falhaService.findById(id);

        if (falhaOptional.isPresent()) {
            Falha falha = falhaOptional.get();
            falha.setMaquinaId(id);
            falha.setDataFalha(falhaDetails.getDataFalha());
            falha.setProblema(falhaDetails.getProblema());
            falha.setPrioridade(falhaDetails.getPrioridade());
            falha.setTecnicoId(id);
            return ResponseEntity.ok(falhaService.save(falha));
        }
        return ResponseEntity.notFound().build();
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
