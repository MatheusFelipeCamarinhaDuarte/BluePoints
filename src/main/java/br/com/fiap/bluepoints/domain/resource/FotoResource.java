package br.com.fiap.bluepoints.domain.resource;

import br.com.fiap.bluepoints.domain.dto.request.FotoRequest;
import br.com.fiap.bluepoints.domain.dto.response.FotoResponse;
import br.com.fiap.bluepoints.domain.entity.Foto;
import br.com.fiap.bluepoints.domain.service.FotoService;
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

// TODO: Foto Resource
@RestController
@RequestMapping(value = "/foto")
public class FotoResource implements ResourceDTO<FotoRequest, FotoResponse> {
    @Autowired
    private FotoService service;

    @GetMapping
    public ResponseEntity<Collection<FotoResponse>> findAll(
            @RequestParam(name = "caminho",required = false) String caminho
    ){
        Foto foto = Foto.builder()
                .src(caminho)
                .build();
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase()
                .withIgnoreNullValues();
        Example<Foto> example = Example.of(foto,matcher);
        var entities = service.findAll(example);
        var response = entities.stream().map(service::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<FotoResponse> findById(@PathVariable Long id) {
        var entity = service.findById(id);
        if(Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }
    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<FotoResponse> save(@RequestBody @Valid FotoRequest r) {
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
