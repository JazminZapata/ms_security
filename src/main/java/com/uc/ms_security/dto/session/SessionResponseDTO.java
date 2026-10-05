package com.uc.ms_security.dto.session;

import lombok.Value;

import java.time.LocalDateTime;

//Forma en como se reesponde la informacion de la sesion al cliente
@Value
public class SessionResponseDTO {
    Long id;
    String token;
    LocalDateTime expiration;
    String code2FA;
}
