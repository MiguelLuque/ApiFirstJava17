package com.miguelluque.apifirst.repository;

import com.miguelluque.apifirst.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {
}
