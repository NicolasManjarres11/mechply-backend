package com.devsenior.nmanja.mechply.user.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsenior.nmanja.mechply.user.model.enums.Role;

public record UserResponseDTO(
        //TODO: Agregar Workshop ID, validar si agregarlo en la lógica de negocio o en el mapper. Por ahora lo omitimos
        UUID id,
        String name,
        String email,
        String phoneNumber,
        Role role,
        Boolean isActive,
        LocalDateTime creationDate
) {
}
