package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.PremioRequest;
import br.com.fiap.bluepoints.domain.dto.response.PremioResponse;
import br.com.fiap.bluepoints.domain.entity.Premio;
import br.com.fiap.bluepoints.domain.repository.PremioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PremioService implements ServiceDTO<Premio, PremioRequest, PremioResponse> {

    @Autowired
    private PremioRepository repo;

    @Override
    public Premio toEntity(PremioRequest dto) {
        return Premio.builder()
                .nome(dto.nome())
                .custo(dto.custo())
                .build();
    }

    @Override
    public PremioResponse toResponse(Premio e) {
        return PremioResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .custo(e.getCusto())
                .build();
    }

    @Override
    public Collection<Premio> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Premio> findAll(Example<Premio> example) {
        return repo.findAll(example);
    }

    @Override
    public Premio findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Premio save(Premio e) {
        return repo.save(e);
    }
}
