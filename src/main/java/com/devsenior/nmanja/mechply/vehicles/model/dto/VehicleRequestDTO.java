package com.devsenior.nmanja.mechply.vehicles.model.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleRequestDTO(
        UUID clientId,

        @NotBlank(message = "La matrícula es obligatoria.")
        String licensePlate,

        @NotBlank(message = "La marca y el modelo son obligatorios.")
        String makeModel,

        @NotNull(message = "El año es obligatorio.")
        Short year,

        @NotBlank(message = "El color es obligatorio.")
        String color,

        @NotNull(message = "El kilometraje es obligatorio.")
        Integer mileage
) {
}
