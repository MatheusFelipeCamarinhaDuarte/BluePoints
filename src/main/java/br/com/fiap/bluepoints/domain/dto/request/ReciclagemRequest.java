package br.com.fiap.bluepoints.domain.dto.request;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ReciclagemRequest(

        @PositiveOrZero(message = "O valor do pontos tem que ser maior ou igual a 0")
        Integer pontos,

        @AssertFalse(message = "A reciclagem tem que ser inserida como falsa")
        Boolean isValidado,

        @NotNull(message = "A reciclagem tem que estar ligada a alguma pessoa")
        AbstractRequest pessoa,

        @NotNull(message = "A Foto não pode ser nula")
        AbstractRequest foto
) {
}
