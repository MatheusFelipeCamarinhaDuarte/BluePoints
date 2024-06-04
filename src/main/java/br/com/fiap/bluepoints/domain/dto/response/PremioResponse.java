package br.com.fiap.bluepoints.domain.dto.response;

import lombok.Builder;

@Builder
public record PremioResponse(
        Long id,
        String nome,
        Integer custo
) {
}
