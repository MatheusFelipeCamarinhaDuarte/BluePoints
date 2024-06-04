package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.ReciclagemRequest;
import br.com.fiap.bluepoints.domain.dto.response.ReciclagemResponse;
import br.com.fiap.bluepoints.domain.entity.Reciclagem;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ReciclagemService implements ServiceDTO<Reciclagem, ReciclagemRequest, ReciclagemResponse>{
    @Override
    public Reciclagem toEntity(ReciclagemRequest dto) {
        return null;
    }

    @Override
    public ReciclagemResponse toResponse(Reciclagem e) {
        return null;
    }

    @Override
    public Collection<Reciclagem> findAll() {
        return List.of();
    }

    @Override
    public Collection<Reciclagem> findAll(Example<Reciclagem> example) {
        return List.of();
    }

    @Override
    public Reciclagem findById(Long id) {
        return null;
    }

    @Override
    public Reciclagem save(Reciclagem e) {
        return null;
    }
}
