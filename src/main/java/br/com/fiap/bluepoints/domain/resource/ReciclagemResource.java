package br.com.fiap.bluepoints.domain.resource;

import br.com.fiap.bluepoints.domain.dto.request.ReciclagemRequest;
import br.com.fiap.bluepoints.domain.dto.response.ReciclagemResponse;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.entity.Reciclagem;
import br.com.fiap.bluepoints.domain.entity.Usuario;
import br.com.fiap.bluepoints.domain.service.ReciclagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.Objects;

// TODO: Reciclagem Resource
@RestController
@RequestMapping(value = "/reciclagem")
public class ReciclagemResource implements  ResourceDTO<ReciclagemRequest, ReciclagemResponse> {

    @Autowired
    private ReciclagemService service;

    @GetMapping
    public ResponseEntity<Collection<ReciclagemResponse>> findAll(
            @RequestParam(name = "valido",required = false) Boolean valido,
            @RequestParam(name = "pessoa.nome",required = false) String nome,
            @RequestParam(name = "pessoa.sobrenome",required = false) String sobrenome
    ){
        Pessoa pessoa = Pessoa.builder()
                .sobrenome(sobrenome)
                .nome(nome)
                .build();

        Reciclagem reciclagem = Reciclagem.builder()
                .isValidado(valido)
                .pessoa(pessoa)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase()
                .withIgnoreNullValues();
        Example<Reciclagem> example = Example.of(reciclagem,matcher);
        var entities = service.findAll(example);
        var response = entities.stream().map(service::toResponse).toList();
        return ResponseEntity.ok(response);
    }


    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReciclagemResponse> findById(@PathVariable Long id) {
        var entity = service.findById(id);
        if(Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }
    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<ReciclagemResponse> save(@RequestBody @Valid ReciclagemRequest r) {
        var entity = service.toEntity(r);
        entity = service.save(entity);
        var response = service.toResponse(entity);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
