package br.com.fiap.smartfrango.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.smartfrango.model.Rotina;
import br.com.fiap.smartfrango.repository.RotinaRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("rotina")
@Slf4j
public class RotinaController {

    @Autowired
    RotinaRepository repository;

    @GetMapping
    public List<Rotina> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Rotina create(@RequestBody Rotina rotina) {
        log.info("Cadastrando rotina {}", rotina);
        return repository.save(rotina);
    }

    @GetMapping("{id}")
    public ResponseEntity<Rotina> show(@PathVariable Long id) {
        log.info("Buscando rotina com id {}", id);


        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando rotina {}", id);
        verificarSeRotinaExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Rotina update(@PathVariable Long id, @RequestBody Rotina rotina) {
        log.info("Atualizar rotina {} para {}", id, rotina);

        verificarSeRotinaExiste(id);
        rotina.setId(id);
        return repository.save(rotina);
    }

    private void verificarSeRotinaExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Não existe rotina com o id informado"));
    }

}
