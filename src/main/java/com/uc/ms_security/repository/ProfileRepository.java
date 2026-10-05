package com.uc.ms_security.repository;

import com.uc.ms_security.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    // Find -> *
    // Buscamos el perfil del usuario por medio del id del usuario.
    Optional<Profile> findByUserId(Long userId);

    // Verificar existencia dle perfil.
    boolean existsByUserId(Long userId);
}