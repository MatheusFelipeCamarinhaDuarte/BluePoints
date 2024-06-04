package br.com.fiap.bluepoints.domain.dto.response;

import lombok.Builder;

@Builder
public record ReciclagemResponse(
        Long id,
        String nome,
        Boolean isValido,
        Integer pontos,
        FotoResponse foto,
        PessoaResponse pessoa
) {
}