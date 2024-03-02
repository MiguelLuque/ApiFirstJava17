package com.miguelluque.apifirst.persistence;

import com.miguelluque.apifirst.entity.Role;
import com.miguelluque.apifirst.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    RoleJpaRepository jpaRepository;

    @Override
    public Optional<Role> findByName(String name) {
        return jpaRepository.findByName(name);
    }
}
