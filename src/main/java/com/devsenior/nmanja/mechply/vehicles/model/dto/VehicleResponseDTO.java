package com.devsenior.nmanja.mechply.vehicles.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record VehicleResponseDTO(
        UUID id,
        UUID clientId,
        String licensePlate,
        String makeModel,
        Short year,
        String color,
        Integer mileage,
        LocalDateTime creationDate
) {
}
