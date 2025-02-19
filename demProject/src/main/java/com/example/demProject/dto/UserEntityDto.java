package com.example.demProject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demProject.entity.UserEntity}
 */
@Value
public class UserEntityDto implements Serializable {
    @NotEmpty
    String username;
    @NotEmpty
    String password;
}