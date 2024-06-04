package br.com.fiap.bluepoints.domain.service;

import br.com.fiap.bluepoints.domain.dto.request.UsuarioRequest;
import br.com.fiap.bluepoints.domain.dto.response.UsuarioResponse;
import br.com.fiap.bluepoints.domain.entity.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest, UsuarioResponse>{
    @Override
    public Usuario toEntity(UsuarioRequest dto) {
        return null;
    }

    @Override
    public UsuarioResponse toResponse(Usuario e) {
        return null;
    }

    @Override
    public Collection<Usuario> findAll() {
        return List.of();
    }

    @Override
    public Collection<Usuario> findAll(Example<Usuario> example) {
        return List.of();
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public Usuario save(Usuario e) {
        return null;
    }
}
