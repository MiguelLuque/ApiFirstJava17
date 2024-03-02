package com.miguelluque.apifirst.repository;

import com.miguelluque.apifirst.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    User save(User user);
}
