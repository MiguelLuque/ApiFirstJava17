package com.miguelluque.apifirst.persistence;

import com.miguelluque.apifirst.entity.User;
import com.miguelluque.apifirst.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserJpaRepository jpaRepository;


    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }
}
