package com.devsenior.nmanja.mechply.user.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsenior.nmanja.mechply.user.model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user", indexes = @Index(name = "idx_email", columnList = "email", unique = true))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID workshopId; // FK pendiente hacia workshop.id (tabla aún no creada en este sprint), se mantendrá opcional, no todos los usuarios son mecánicos que tienen un taller.


    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = "El correo electrónico no es válido.")
    private String email;

    @Column(name = "password__hash", nullable = false)
    @NotBlank(message = "La contraseña es obligatoria.")
    private String password;

    @Column(name = "phone_number", nullable = false)
    @NotBlank(message = "El número de teléfono es obligatorio.")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

}


