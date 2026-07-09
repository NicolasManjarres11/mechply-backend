package com.devsenior.nmanja.mechply.user.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsenior.nmanja.mechply.user.model.enums.Role;

public record UserResponseDTO(
        UUID id,
        UUID workshopId,
        String name,
        String email,
        String phoneNumber,
        Role role,
        Boolean isActive,
        LocalDateTime creationDate
) {
}
