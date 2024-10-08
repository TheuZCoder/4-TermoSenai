package com.theuz.apispringjpa.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.theuz.apispringjpa.DTO.ManutencaoDTO;
import com.theuz.apispringjpa.Model.Manutencao;
import com.theuz.apispringjpa.Model.Maquina;
import com.theuz.apispringjpa.Model.Tecnico;
import com.theuz.apispringjpa.Service.ManutencaoService;
import com.theuz.apispringjpa.Service.MaquinaService;
import com.theuz.apispringjpa.Service.TecnicoService;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    @Autowired
    private MaquinaService maquinaService;

    @Autowired
    private TecnicoService tecnicoService;

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

    // Método para salvar a manutenção usando apenas o ID da máquina e técnico
    @PostMapping
    public ResponseEntity<Manutencao> save(@RequestBody ManutencaoDTO manutencaoDTO) {
        Optional<Maquina> maquinaOptional = maquinaService.findById(manutencaoDTO.getMaquinaId());
        Optional<Tecnico> tecnicoOptional = tecnicoService.findById(manutencaoDTO.getTecnicoId());

        if (maquinaOptional.isPresent() && tecnicoOptional.isPresent()) {
            Maquina maquina = maquinaOptional.get();
            Tecnico tecnico = tecnicoOptional.get();

            Manutencao manutencao = new Manutencao();
            manutencao.setMaquina(maquina);
            manutencao.setDataManutencao(manutencaoDTO.getDataManutencao());
            manutencao.setTipo(manutencaoDTO.getTipo());
            manutencao.setPecasTrocadas(manutencaoDTO.getPecasTrocadas());
            manutencao.setTempoParado(manutencaoDTO.getTempoParado());
            manutencao.setTecnico(tecnico);
            manutencao.setObservacoes(manutencaoDTO.getObservacoes());

            Manutencao savedManutencao = manutencaoService.save(manutencao);
            return ResponseEntity.ok(savedManutencao);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Método para atualizar a manutenção usando apenas o ID da máquina e técnico
    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> updateManutencao(
            @PathVariable Integer id, 
            @RequestBody ManutencaoDTO manutencaoDTO) {

        Optional<Manutencao> manutencaoOptional = manutencaoService.findById(id);
        Optional<Maquina> maquinaOptional = maquinaService.findById(manutencaoDTO.getMaquinaId());
        Optional<Tecnico> tecnicoOptional = tecnicoService.findById(manutencaoDTO.getTecnicoId());

        if (manutencaoOptional.isPresent() && maquinaOptional.isPresent() && tecnicoOptional.isPresent()) {
            Manutencao manutencao = manutencaoOptional.get();
            Maquina maquina = maquinaOptional.get();
            Tecnico tecnico = tecnicoOptional.get();

            manutencao.setMaquina(maquina);
            manutencao.setDataManutencao(manutencaoDTO.getDataManutencao());
            manutencao.setTipo(manutencaoDTO.getTipo());
            manutencao.setPecasTrocadas(manutencaoDTO.getPecasTrocadas());
            manutencao.setTempoParado(manutencaoDTO.getTempoParado());
            manutencao.setTecnico(tecnico);
            manutencao.setObservacoes(manutencaoDTO.getObservacoes());

            Manutencao updatedManutencao = manutencaoService.save(manutencao);
            return ResponseEntity.ok(updatedManutencao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Manutencao> manutencao = manutencaoService.findById(id);
        if (manutencao.isPresent()) {
            manutencaoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
