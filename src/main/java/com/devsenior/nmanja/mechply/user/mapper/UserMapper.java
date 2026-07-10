package com.devsenior.nmanja.mechply.user.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.devsenior.nmanja.mechply.user.model.dto.UserRequestDTO;
import com.devsenior.nmanja.mechply.user.model.dto.UserResponseDTO;
import com.devsenior.nmanja.mechply.user.model.entity.User;

@Component
public class UserMapper {

    //DTO Request to entity
    public User toEntity(UserRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        //TODO: Agregar Workshop ID, validar si agregarlo en la lógica de negocio o en el mapper. Por ahora lo omitimos

        return User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .phoneNumber(dto.phoneNumber())
                .role(dto.role())
                .isActive(true) // o gestionar esto en el servicio
                .creationDate(LocalDateTime.now()) // puede ajustarse en el servicio
                .build();
    }

    //Entity to DTO Response

    public UserResponseDTO toResponseDTO(User user) {
        if (user == null) {
            return null;
        }

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole(),
                user.getIsActive(),
                user.getCreationDate()
        );
    }

    public void updateEntityFromRequest(UserRequestDTO dto, User user) {
        if (dto == null || user == null) {
            return;
        }

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPhoneNumber(dto.phoneNumber());
    }

}


