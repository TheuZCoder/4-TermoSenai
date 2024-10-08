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

import com.theuz.apispringjpa.Model.Tecnico;
import com.theuz.apispringjpa.Service.TecnicoService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/tecnicos")
public class TecnicosController {
    
    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public List<Tecnico> findAll() {
        return tecnicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
        Optional<Tecnico> tecnico = tecnicoService.findById(id);
        if (tecnico.isPresent()) {
            return ResponseEntity.ok(tecnico.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping 
    public Tecnico save(@RequestBody Tecnico tecnico) {
        return tecnicoService.save(tecnico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> updatetecnico(
            @PathVariable Integer id,
            @RequestBody Tecnico tecnicoDetails) {
        
        Optional<Tecnico> tecnicoOptional = tecnicoService.findById(id);

        if (tecnicoOptional.isPresent()) {
            Tecnico tecnico = tecnicoOptional.get();
            tecnico.setNome(tecnicoDetails.getNome());
            tecnico.setEspecialidade(tecnicoDetails.getEspecialidade());
            tecnico.setDisponibilidade(tecnicoDetails.getDisponibilidade());
            
            final Tecnico updatedtecnico = tecnicoService.save(tecnico);
            return ResponseEntity.ok(updatedtecnico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        tecnicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
