package com.devsenior.nmanja.mechply.user.model.dto;

import java.util.UUID;

import com.devsenior.nmanja.mechply.user.model.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        UUID workshopId,

        @NotBlank(message = "El nombre es obligatorio.")
        String name,

        @NotBlank(message = "El correo electrónico es obligatorio.")
        @Email(message = "El correo electrónico no es válido.")
        String email,

        @NotBlank(message = "La contraseña es obligatoria.")
        String password,

        @NotBlank(message = "El número de teléfono es obligatorio.")
        String phoneNumber,

        @NotNull(message = "El rol es obligatorio.")
        Role role
) {
}
