package com.uday.coderHack.exchanges;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class RegisterUserRequest {
    @NotEmpty
    private String username;
}
