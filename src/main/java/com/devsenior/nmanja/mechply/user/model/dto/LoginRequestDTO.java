package com.devsenior.nmanja.mechply.user.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(

    @NotEmpty(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico tiene un formato inválido")
    String email,

    @NotEmpty(message = "La contraseña es obligatoria") 
    @Size(min = 6, message = "La contraseña debe contener minino 6 caracteres")    
    String password
) {
}