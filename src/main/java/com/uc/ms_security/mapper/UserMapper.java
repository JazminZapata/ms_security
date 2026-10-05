package com.uc.ms_security.mapper;

import com.uc.ms_security.dto.session.SessionResponseDTO;
import com.uc.ms_security.dto.session.UserSessionsResponseDTO;
import com.uc.ms_security.dto.user.CreateUserDTO;
import com.uc.ms_security.dto.user.UpdateUserDTO;
import com.uc.ms_security.dto.user.UserDetailResponseDTO;
import com.uc.ms_security.dto.user.UserResponseDTO;
import com.uc.ms_security.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ProfileMapper profileMapper;
    private final SessionMapper sessionMapper;

    public User toEntity(CreateUserDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }

    public void updateEntity(UpdateUserDTO dto, User user) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        if (dto.getPassword() != null) {
            user.setPassword(dto.getPassword());
        }
    }

    public UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public UserDetailResponseDTO toDetailResponseDTO(User user) {
        return new UserDetailResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                //En esta linea es donde se hace la invocacion del perfil. por medio de la invocacion llama al repository y alli hace la consulta del perfil
                profileMapper.toResponseDTO(user.getProfile())
        );
    }

    public UserSessionsResponseDTO toSessionsResponseDTO(User user) {
        return new UserSessionsResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                //Sobre este se ejecuta el join -> "Consulta o pide consultar a la BD"
                sessionMapper.toResponseDTOList(user.getSessions())
        );
    }

    public List<UserResponseDTO> toResponseDTOList(List<User> users) {
        return users.stream()
                // A esta lista pasela por UserResponseDTO para importar valores correctos a mostrar del usuario
                .map(this::toResponseDTO)
                .toList();
    }
}