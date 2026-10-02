package com.uc.ms_security.entity;

import jakarta.persistence.*;
//Lombok -> Libreria que genera constructor, get y set en el momento que se usa
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor

//Como se va a ver mi Usuario en la base de datos, teneindo en cuenta restricciones
//@-> Decoradores: Lo veo como la firma que uno mismo le da a cada campo para la base de datos
// Para una base de datos no relacional puede que lo unico que cambien son los decoradores ya que no es lo mismo hacer un unique en sql que en el nosql
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    //Este nombre no puede ser nulo, y tiene un tamaño de caracteres definido
    //@Column como necesito que se cree la tabla en la base de datos
    @Column(
            nullable = false,
            length = 100
    )
    private String name;

    //Email unico -> UNIQUE en la tabla
    @Column(
            nullable = false,
            unique = true,
            length = 150
    )
    private String email;

    //La contraseña no puede ser vacia o nula
    @Column(
            nullable = false
    )
    private String password;
}