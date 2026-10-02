package com.uc.ms_security.dto.user;

import lombok.Value;

@Value

//DTO SALIDA
//Cuando devuelva la informacion evite el campo de la contraseña.

public class UserResponseDTO {
    Long id;
    String name;
    String email;
}