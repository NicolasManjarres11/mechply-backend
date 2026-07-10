package com.devsenior.nmanja.mechply.workshop.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "workshop")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio.")
    private String name;

    @NotBlank(message = "La ciudad es obligatoria.")
    @Column(nullable = false)
    private String city;

    @NotBlank(message = "La dirección es obligatoria.")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "El número de teléfono es obligatorio.")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    
}
