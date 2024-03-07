package br.com.fiap.smartfrango.controller;
import br.com.fiap.smartfrango.model.Rotina;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("rotina")
public class RotinaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Rotina> repository = new ArrayList<>();

    @GetMapping
    public List<Rotina> index(){
        return repository;
    }

    @PostMapping
    public ResponseEntity<Rotina> create(@RequestBody Rotina rotina){ //binding
        log.info("Cadastrando rotina {}", rotina);
        repository.add(rotina);
        return ResponseEntity.status(HttpStatus.CREATED).body(rotina);
    }

    @GetMapping("{id}")
    public ResponseEntity<Rotina> show(@PathVariable Long id){
        log.info("buscando rotina com id {}", id);

        for(Rotina rotina : repository){
            if (rotina.id().equals(id))
                return ResponseEntity.status(HttpStatus.OK).body(rotina);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Rotina> update(@PathVariable Long id, @RequestBody Rotina updatedRotina) {
        for (int i = 0; i < repository.size(); i++) {
            Rotina rotina = repository.get(i);
            if (rotina.id().equals(id)) {
                updatedRotina = new Rotina(id, updatedRotina.nome(), updatedRotina.exercicios());
                repository.set(i, updatedRotina);
                return ResponseEntity.ok(updatedRotina);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Iterator<Rotina> iterator = repository.iterator();
        while (iterator.hasNext()) {
            Rotina rotina = iterator.next();
            if (rotina.id().equals(id)) {
                iterator.remove();
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

