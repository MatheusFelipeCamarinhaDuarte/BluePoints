package br.com.fiap.bluepoints.domain.dto.request;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ReciclagemRequest(

        @PositiveOrZero(message = "O valor do pontos tem que ser maior ou igual a 0")
        Integer pontos,

        @NotNull(message = "A reciclagem tem que estar ligada a algum usuário")
        AbstractRequest usuario,

        @NotNull(message = "A Foto não pode ser nula")
        AbstractRequest foto
) {
}
