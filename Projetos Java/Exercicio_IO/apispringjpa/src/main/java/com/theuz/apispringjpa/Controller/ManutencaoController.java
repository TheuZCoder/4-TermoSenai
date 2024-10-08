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

import com.theuz.apispringjpa.Model.Manutencao;
import com.theuz.apispringjpa.Service.ManutencaoService;


import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {
    
    @Autowired
    private ManutencaoService manutencaoService;

    @GetMapping
    public List<Manutencao> findAll() {
        return manutencaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> findById(@PathVariable Integer id) {
        Optional<Manutencao> manutencao = manutencaoService.findById(id);
        if (manutencao.isPresent()) {
            return ResponseEntity.ok(manutencao.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Manutencao save(@RequestBody Manutencao manutencao){
        return manutencaoService.save(manutencao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> updateManutencao(
            @PathVariable Integer id,
            @RequestBody Manutencao manutencaoDetails) {
        
        Optional<Manutencao> manutencaoOptional = manutencaoService.findById(id);

        if (manutencaoOptional.isPresent()) {
            Manutencao manutencao = manutencaoOptional.get();
            manutencao.setMaquinaId(id);
            manutencao.setDataManutencao(manutencaoDetails.getDataManutencao());
            manutencao.setTipo(manutencaoDetails.getTipo());
            manutencao.setPecasTrocadas(manutencaoDetails.getPecasTrocadas());
            manutencao.setTempoParado(manutencaoDetails.getTempoParado());
            manutencao.setTecnicoId(id);
            manutencao.setObservacoes(manutencaoDetails.getObservacoes());

            final Manutencao updatedManutencao = manutencaoService.save(manutencao);
            return ResponseEntity.ok(updatedManutencao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Manutencao> deleteById(@PathVariable Integer id) {
        manutencaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
