package com.miguelluque.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

//@Data // Para generar automáticamente getters, setters, toString, equals y hashCode
@Entity // Esta anotación indica que esta clase es una entidad JPA y corresponde con el nombre de la tabla
@Builder // Para utilizar el patrón de diseño Builder
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
}
