package com.devsenior.nmanja.mechply.vehicles.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devsenior.nmanja.mechply.user.model.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private User client; // FK pendiente hacia user.id, se mantendrá opcional, no todos los vehículos tienen un cliente asociado.

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;
    
    @Column(name = "make_model", nullable = false)
    private String makeModel;

    @Column(name = "year", nullable = false)
    private Short year;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
}
