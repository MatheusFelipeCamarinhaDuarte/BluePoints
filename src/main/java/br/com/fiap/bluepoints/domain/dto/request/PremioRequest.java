package br.com.fiap.bluepoints.domain.dto.request;

import jakarta.validation.constraints.NotNull;

public record PremioRequest (

        @NotNull(message = "O nome não pode ser nulo")
        String nome,

        @NotNull(message = "O custo não pode ser nulo")
        Integer custo
) {
}
