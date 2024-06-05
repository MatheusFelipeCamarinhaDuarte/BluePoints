package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.FotoRequest;
import br.com.fiap.bluepoints.domain.dto.response.FotoResponse;
import br.com.fiap.bluepoints.domain.entity.Foto;
import br.com.fiap.bluepoints.domain.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FotoService implements ServiceDTO<Foto, FotoRequest, FotoResponse> {

    @Autowired
    private FotoRepository repo;

    @Override
    public Foto toEntity(FotoRequest dto) {
        return Foto.builder()
                .src(dto.src())
                .build();
    }

    @Override
    public FotoResponse toResponse(Foto e) {
        return FotoResponse.builder()
                .id(e.getId())
                .src(e.getSrc())
                .build();
    }

    @Override
    public Collection<Foto> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Foto> findAll(Example<Foto> example) {
        return repo.findAll(example);
    }

    @Override
    public Foto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Foto save(Foto e) {
        return repo.save(e);
    }
}
