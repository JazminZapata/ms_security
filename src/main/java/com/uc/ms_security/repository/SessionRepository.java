package com.uc.ms_security.repository;

import com.uc.ms_security.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


//Inicio de ocnsultas SQL

public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findAllByUserId(Long userId);

    Optional<Session> findByIdAndUserId(Long sessionId, Long userId);

    boolean existsByToken(String token);

    //Verificar que ese token si le pertenece a ese usuario, y que no sea de otro usuario
    boolean existsByTokenAndIdNot(String token, Long id);

    // Se puede añadir metodo de segundo factor de autenticacion si exista
    // Atributo para identificar si la sesion ya quedo validada.
    
}
