package br.com.fiap.bluepoints.domain.resource;

import br.com.fiap.bluepoints.domain.dto.request.PremioRequest;
import br.com.fiap.bluepoints.domain.dto.response.PremioResponse;
import br.com.fiap.bluepoints.domain.dto.response.UsuarioResponse;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.entity.Premio;
import br.com.fiap.bluepoints.domain.entity.Usuario;
import br.com.fiap.bluepoints.domain.service.PremioService;
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

// TODO: Premio Resource
@RestController
@RequestMapping(value = "/premio")
public class PremioResource implements ResourceDTO<PremioRequest, PremioResponse>{
    @Autowired
    private PremioService service;

    @GetMapping
    public ResponseEntity<Collection<PremioResponse>> findAll(
            @RequestParam(name = "nome",required = false) String nome,
            @RequestParam(name = "custo",required = false) Integer custo
    ){
        Premio premio = Premio.builder()
                .nome(nome)
                .custo(custo)
                .build();
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase()
                .withIgnoreNullValues();
        Example<Premio> example = Example.of(premio,matcher);
        var entities = service.findAll(example);
        var response = entities.stream().map(service::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<PremioResponse> findById(@PathVariable Long id) {
        var entity = service.findById(id);
        if(Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }
    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<PremioResponse> save(@RequestBody @Valid PremioRequest r) {
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
