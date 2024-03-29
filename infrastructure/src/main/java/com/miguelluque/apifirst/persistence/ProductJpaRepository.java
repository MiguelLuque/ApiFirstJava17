package com.miguelluque.apifirst.persistence;

import com.miguelluque.apifirst.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {
}
