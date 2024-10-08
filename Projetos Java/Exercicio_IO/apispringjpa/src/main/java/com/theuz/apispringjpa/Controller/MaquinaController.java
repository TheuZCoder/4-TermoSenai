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

import com.theuz.apispringjpa.Model.Maquina;
import com.theuz.apispringjpa.Service.MaquinaService;


import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/maquinas")
public class MaquinaController {
    
    @Autowired
    private MaquinaService maquinaService;

    @GetMapping
    public List<Maquina> findAll() {
        return maquinaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maquina> findById(@PathVariable Integer id) {
        Optional<Maquina> maquina = maquinaService.findById(id);
        if (maquina.isPresent()) {
            return ResponseEntity.ok(maquina.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping 
    public Maquina save(@RequestBody Maquina maquina) {
        return maquinaService.save(maquina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maquina> updatemaquina(
            @PathVariable Integer id,
            @RequestBody Maquina maquinaDetails) {
        
        Optional<Maquina> maquinaOptional = maquinaService.findById(id);

        if (maquinaOptional.isPresent()) {
            Maquina maquina = maquinaOptional.get();
            maquina.setCodigo(maquinaDetails.getCodigo());
            maquina.setNome(maquinaDetails.getNome());
            maquina.setModelo(maquinaDetails.getModelo());
            maquina.setFabricante(maquinaDetails.getFabricante());
            maquina.setDataAquisicao(maquinaDetails.getDataAquisicao());
            maquina.setTempoVidaEstimado(maquinaDetails.getTempoVidaEstimado());
            maquina.setLocalizacao(maquinaDetails.getLocalizacao());
            maquina.setDetalhes(maquinaDetails.getDetalhes());
            maquina.setManual(maquinaDetails.getManual());
            
            
            final Maquina updatedmaquina = maquinaService.save(maquina);
            return ResponseEntity.ok(updatedmaquina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        maquinaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
