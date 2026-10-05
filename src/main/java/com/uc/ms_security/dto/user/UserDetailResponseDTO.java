package com.uc.ms_security.dto.user;

import com.uc.ms_security.dto.profile.ProfileResponseDTO;
import lombok.Value;

@Value
public class UserDetailResponseDTO {
    Long id;
    String name;
    String email;
    ProfileResponseDTO profile;
}

//  No se añade Sesison y que esa decision se toma segun lo que uno necesite
// Haste la pregunta de ¿Es necesario mostrar siempre las sesiones de un usuario en el detalle del usuario?
// ¿Cuanto me costaria esto? Hay que recordar que entre mas cosas se cargen en pantalla, menor rendimiento.