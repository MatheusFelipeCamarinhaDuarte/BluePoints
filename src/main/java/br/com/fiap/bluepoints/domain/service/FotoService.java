package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.FotoRequest;
import br.com.fiap.bluepoints.domain.dto.response.FotoResponse;
import br.com.fiap.bluepoints.domain.entity.Foto;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FotoService implements ServiceDTO<Foto, FotoRequest, FotoResponse>{
    @Override
    public Foto toEntity(FotoRequest dto) {
        return null;
    }

    @Override
    public FotoResponse toResponse(Foto e) {
        return null;
    }

    @Override
    public Collection<Foto> findAll() {
        return List.of();
    }

    @Override
    public Collection<Foto> findAll(Example<Foto> example) {
        return List.of();
    }

    @Override
    public Foto findById(Long id) {
        return null;
    }

    @Override
    public Foto save(Foto e) {
        return null;
    }
}
