package com.abderahman.booknetwork.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record RegistrationRequest(
        @NotEmpty(message = "First name is required")
        @NotBlank(message = "First name is required")
        String firstName,

        @NotEmpty(message = "Last name is required")
        @NotBlank(message = "Last name is required")
        String lastName,

        @NotEmpty(message = "Email is required")
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        @Column(unique = true, nullable = false)
        String email,

        @NotEmpty(message = "Password is required")
        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password should be 8 char long minimum")
        String password
) {
}
