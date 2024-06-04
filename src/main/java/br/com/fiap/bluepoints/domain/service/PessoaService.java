package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.PessoaRequest;
import br.com.fiap.bluepoints.domain.dto.response.PessoaResponse;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PessoaService implements ServiceDTO <Pessoa, PessoaRequest, PessoaResponse>{
    @Override
    public Pessoa toEntity(PessoaRequest dto) {
        return null;
    }

    @Override
    public PessoaResponse toResponse(Pessoa e) {
        return null;
    }

    @Override
    public Collection<Pessoa> findAll() {
        return List.of();
    }

    @Override
    public Collection<Pessoa> findAll(Example<Pessoa> example) {
        return List.of();
    }

    @Override
    public Pessoa findById(Long id) {
        return null;
    }

    @Override
    public Pessoa save(Pessoa e) {
        return null;
    }
}
