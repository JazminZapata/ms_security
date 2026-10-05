package com.uc.ms_security.repository;

import com.uc.ms_security.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//JPARepository vas a usar la tabla User y vamos a buscar por medio de long < USER, LONG>
//Se encarga de general las consultas
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    //
    @EntityGraph(attributePaths = "profile")
    //Busque con el perfil JOIN interno del usuario con la entidad perfil. 
    Optional<User> findWithProfileById(Long id);
}
