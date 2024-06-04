package br.com.fiap.bluepoints.domain.dto.request;

import jakarta.validation.constraints.*;

public record PessoaRequest(
        @NotNull(message = "O nome é obrigatório")
        String nome,

        @NotNull(message = "O sobrenome é obrigatório")
        String sobrenome,

        @PositiveOrZero(message = "Os pontos precisam ser positivos ou 0")
        @NotNull(message = "Pontos não podem ser nulos")
        Integer pontos

) {
}