package com.miguelluque.apifirst.service;


import com.miguelluque.apifirst.dto.AuthRequest;
import com.miguelluque.apifirst.dto.AuthResponse;
import com.miguelluque.apifirst.entity.Role;
import com.miguelluque.apifirst.entity.User;
import com.miguelluque.apifirst.repository.RoleRepository;
import com.miguelluque.apifirst.repository.UserRepository;
import com.miguelluque.apifirst.usecase.ManageAuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManageAuthService implements ManageAuthUseCase {


    private final JwtTokenService jwtTokenService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Transactional(readOnly = true)
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);

        // Converting userDetail to UserDetails
        return user
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + email));
    }

    @Override
    public AuthResponse login(User user) {
        AuthResponse response = new AuthResponse();
        String accessToken = jwtTokenService.generateAccessToken(user);

        response.setEmail(user.getEmail());
        response.setToken(accessToken);
        return response;
    }


    @Override
    @Transactional
    public AuthResponse registration(AuthRequest authRequest) {

        this.checkUser(authRequest.getEmail());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(authRequest.getPassword());
        Role customerRole = this.findRoleByName("ROLE_CUSTOMER");

        //Create user with authRequest
        User user = User
                .builder()
                .email(authRequest.getEmail())
                .password(password)
                .roles(new HashSet<>(List.of(customerRole)))
                .build();

        //Save user to database
        var userEntity = userRepository.save(user);

        return this.login(userEntity);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Role not found"));
    }

    private void checkUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            throw new AccessDeniedException("Credenciales no válidas");
        }

    }


}
