package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.PessoaRequest;
import br.com.fiap.bluepoints.domain.dto.response.PessoaResponse;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class PessoaService implements ServiceDTO <Pessoa, PessoaRequest, PessoaResponse>{
    @Autowired
    private PessoaRepository repo;

    @Override
    public Pessoa toEntity(PessoaRequest dto) {
        return Pessoa.builder()
                .nome(dto.nome())
                .sobrenome(dto.sobrenome())
                .pontos(dto.pontos())
                .build();
    }

    @Override
    public PessoaResponse toResponse(Pessoa e) {
        return PessoaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .sobrenome(e.getSobrenome())
                .pontos(e.getPontos())
                .build();
    }

    @Override
    public Collection<Pessoa> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Pessoa> findAll(Example<Pessoa> example) {
        return repo.findAll(example);
    }

    @Override
    public Pessoa findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Pessoa save(Pessoa e) {
        return repo.save(e);
    }
}
