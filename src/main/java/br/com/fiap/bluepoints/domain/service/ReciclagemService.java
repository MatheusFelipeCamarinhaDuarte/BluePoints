package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.ReciclagemRequest;
import br.com.fiap.bluepoints.domain.dto.response.ReciclagemResponse;
import br.com.fiap.bluepoints.domain.entity.Foto;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.entity.Reciclagem;
import br.com.fiap.bluepoints.domain.repository.FotoRepository;
import br.com.fiap.bluepoints.domain.repository.PessoaRepository;
import br.com.fiap.bluepoints.domain.repository.ReciclagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class ReciclagemService implements ServiceDTO<Reciclagem, ReciclagemRequest, ReciclagemResponse>{

    @Autowired
    private ReciclagemRepository repo;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private FotoService fotoService;


    @Override
    public Reciclagem toEntity(ReciclagemRequest dto) {
        Pessoa pessoa = null;
        Foto foto = null;
        if(Objects.nonNull(dto.pessoa())){
            pessoa = pessoaService.findById(dto.pessoa().id());
        }
        if(Objects.nonNull(dto.foto())){
            foto = fotoService.findById(dto.foto().id());
        }

        return Reciclagem.builder()
                .pontos(dto.pontos())
                .isValidado(false)
                .foto(foto)
                .pessoa(pessoa)
                .build();
    }

    @Override
    public ReciclagemResponse toResponse(Reciclagem e) {
        var pessoa = pessoaService.toResponse(e.getPessoa());
        var foto = fotoService.toResponse(e.getFoto());
        return ReciclagemResponse.builder()
                .id(e.getId())
                .pontos(e.getPontos())
                .isValido(e.getIsValidado())
                .foto(foto)
                .pessoa(pessoa)
                .build();
    }

    @Override
    public Collection<Reciclagem> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Reciclagem> findAll(Example<Reciclagem> example) {
        return repo.findAll(example);
    }

    @Override
    public Reciclagem findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Reciclagem save(Reciclagem e) {
        return repo.save(e);
    }
}
