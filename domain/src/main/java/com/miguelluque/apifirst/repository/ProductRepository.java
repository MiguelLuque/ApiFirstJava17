package com.miguelluque.apifirst.repository;

import com.miguelluque.apifirst.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface ProductRepository {
    Page<Producto> findAll(Specification<Producto> productoSpecification, PageRequest pageParams);

    Page<Producto> findAll(Pageable pageParams);

    Producto save(Producto entity);

    Optional<Producto> findById(Long id);

    void deleteById(Long id);
}
