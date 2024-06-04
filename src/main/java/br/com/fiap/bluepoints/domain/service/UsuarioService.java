package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.UsuarioRequest;
import br.com.fiap.bluepoints.domain.dto.response.UsuarioResponse;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.entity.Usuario;
import br.com.fiap.bluepoints.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest, UsuarioResponse>{
    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private PessoaService pessoaService;

    @Override
    public Usuario toEntity(UsuarioRequest dto) {
        Pessoa pessoa = null;
        if(Objects.nonNull(dto.pessoa())){
            pessoa = pessoaService.findById(dto.pessoa().id());
        }

        return Usuario.builder()
                .email(dto.email())
                .senha(dto.senha())
                .pessoa(pessoa)
                .build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario e) {
        var pessoa = pessoaService.toResponse(e.getPessoa());

        return UsuarioResponse.builder()
                .id(e.getId())
                .email(e.getEmail())
                .pessoa(pessoa)
                .build();
    }

    @Override
    public Collection<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Usuario> findAll(Example<Usuario> example) {
        return repo.findAll(example);
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario e) {
        return repo.save(e);

    }
}
