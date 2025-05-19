package com.example.usersubscriptionsapi.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SubscriptionDto {

    private Long id;
    @NotBlank
    private String name;
    private String description;
    private Integer popularity;
}
