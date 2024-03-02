package com.miguelluque.apifirst.specification;

import com.miguelluque.apifirst.entity.Producto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductoSpecifications {
    public static Specification<Producto> byFilter(String nombre, String descripcion, Double precioMin, Double precioMax) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nombre != null && !nombre.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
            }
            if (descripcion != null && !descripcion.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("descripcion")), "%" + descripcion.toLowerCase() + "%"));
            }
            if (precioMin != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("precio"), precioMin));
            }
            if (precioMax != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("precio"), precioMax));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}