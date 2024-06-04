package br.com.fiap.bluepoints.domain.dto.response;

import lombok.Builder;

@Builder
public record PessoaResponse(
        Long id,
        String nome,
        String sobrenome,
        Integer pontos
) {
}
