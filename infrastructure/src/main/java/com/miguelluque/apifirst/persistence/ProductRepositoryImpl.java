package com.miguelluque.apifirst.persistence;

import com.miguelluque.apifirst.entity.Producto;
import com.miguelluque.apifirst.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    ProductJpaRepository jpaRepository;


    @Override
    public Page<Producto> findAll(Specification<Producto> productoSpecification, PageRequest pageParams) {
        return jpaRepository.findAll(productoSpecification, pageParams);
    }

    @Override
    public Page<Producto> findAll(Pageable pageParams) {
        return jpaRepository.findAll(pageParams);
    }

    @Override
    public Producto save(Producto entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
