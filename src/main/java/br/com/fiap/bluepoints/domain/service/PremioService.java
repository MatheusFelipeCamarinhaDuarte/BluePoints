package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.PremioRequest;
import br.com.fiap.bluepoints.domain.dto.response.PremioResponse;
import br.com.fiap.bluepoints.domain.entity.Premio;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PremioService implements ServiceDTO<Premio, PremioRequest, PremioResponse> {
    @Override
    public Premio toEntity(PremioRequest dto) {
        return null;
    }

    @Override
    public PremioResponse toResponse(Premio e) {
        return null;
    }

    @Override
    public Collection<Premio> findAll() {
        return List.of();
    }

    @Override
    public Collection<Premio> findAll(Example<Premio> example) {
        return List.of();
    }

    @Override
    public Premio findById(Long id) {
        return null;
    }

    @Override
    public Premio save(Premio e) {
        return null;
    }
}
