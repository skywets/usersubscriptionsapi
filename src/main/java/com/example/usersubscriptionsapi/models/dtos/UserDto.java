package com.example.usersubscriptionsapi.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    @NotBlank
    private String name;
}
