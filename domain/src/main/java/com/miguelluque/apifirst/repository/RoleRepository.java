package com.miguelluque.apifirst.repository;

import com.miguelluque.apifirst.entity.Role;

import java.util.Optional;

public interface RoleRepository {

    Optional<Role> findByName(String name);
}