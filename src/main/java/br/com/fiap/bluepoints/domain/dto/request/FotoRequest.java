package br.com.fiap.bluepoints.domain.dto.request;

import jakarta.validation.constraints.NotNull;

public record FotoRequest(

        @NotNull(message = "O caminho não pode ser nulo")
        String src
) {
}
