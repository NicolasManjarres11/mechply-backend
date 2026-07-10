package com.devsenior.nmanja.mechply.user.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponseDTO(

    @JsonProperty("access_token")
    String access_token,
    String type
) {
    
}
