package com.devsenior.nmanja.mechply.vehicles.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.devsenior.nmanja.mechply.user.model.entity.User;
import com.devsenior.nmanja.mechply.vehicles.model.dto.VehicleRequestDTO;
import com.devsenior.nmanja.mechply.vehicles.model.dto.VehicleResponseDTO;
import com.devsenior.nmanja.mechply.vehicles.model.entity.Vehicle;

@Component
public class VehicleMapper {

    public Vehicle toEntity(VehicleRequestDTO dto, User client) {
        if (dto == null) {
            return null;
        }

        return Vehicle.builder()
                .client(client)
                .licensePlate(dto.licensePlate())
                .makeModel(dto.makeModel())
                .year(dto.year())
                .color(dto.color())
                .mileage(dto.mileage())
                .creationDate(LocalDateTime.now())
                .build();
    }

    public VehicleResponseDTO toResponseDTO(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        return new VehicleResponseDTO(
                vehicle.getId(),
                vehicle.getClient() != null ? vehicle.getClient().getId() : null,
                vehicle.getLicensePlate(),
                vehicle.getMakeModel(),
                vehicle.getYear(),
                vehicle.getColor(),
                vehicle.getMileage(),
                vehicle.getCreationDate()
        );
    }

    public void updateEntityFromRequest(VehicleRequestDTO dto, Vehicle vehicle, User client) {
        if (dto == null || vehicle == null) {
            return;
        }

        vehicle.setClient(client);
        vehicle.setLicensePlate(dto.licensePlate());
        vehicle.setMakeModel(dto.makeModel());
        vehicle.setYear(dto.year());
        vehicle.setColor(dto.color());
        vehicle.setMileage(dto.mileage());
        // creationDate se conserva, no se sobrescribe en una actualización
    }
}
