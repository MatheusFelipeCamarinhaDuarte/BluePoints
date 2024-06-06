package br.com.fiap.bluepoints.domain.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReciclagemResponse(
        Long id,
        Boolean isValidado,
        Integer pontos,
        FotoResponse foto,
        LocalDateTime momento,
        UsuarioResponse usuario
) {
}