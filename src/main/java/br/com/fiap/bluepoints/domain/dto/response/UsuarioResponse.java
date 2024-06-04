package br.com.fiap.bluepoints.domain.dto.response;

import lombok.Builder;

@Builder
public record UsuarioResponse(
        Long id,
        String email,
        PessoaResponse pessoa
) {
}