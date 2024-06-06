package br.com.fiap.bluepoints.domain.resource;

import br.com.fiap.bluepoints.domain.dto.request.PessoaRequest;
import br.com.fiap.bluepoints.domain.dto.response.PessoaResponse;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.service.PessoaService;
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

// TODO: Pessoa Resource
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource implements ResourceDTO<PessoaRequest, PessoaResponse>{
    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<Collection<PessoaResponse>> findAll(
            @RequestParam(name = "nome",required = false) String nome,
            @RequestParam(name = "sobrenome",required = false) String sobrenome
    ){
        Pessoa pessoa = Pessoa.builder()
                .nome(nome)
                .sobrenome(sobrenome)
                .build();
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase()
                .withIgnoreNullValues();
        Example<Pessoa> example = Example.of(pessoa,matcher);
        var entities = service.findAll(example);
        var response = entities.stream().map(service::toResponse).toList();
        return ResponseEntity.ok(response);
    }


    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable Long id) {
        var entity = service.findById(id);
        if(Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }
    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<PessoaResponse> save(@RequestBody @Valid PessoaRequest r) {
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
