package br.com.fiap.bluepoints.domain.dto.response;

import lombok.Builder;

@Builder
public record FotoResponse(
        Long id,
        String src
) {
}
