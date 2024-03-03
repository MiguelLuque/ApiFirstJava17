package com.miguelluque.apifirst.service;

import com.miguelluque.apifirst.dto.AuthRequest;
import com.miguelluque.apifirst.dto.AuthResponse;
import com.miguelluque.apifirst.entity.Role;
import com.miguelluque.apifirst.entity.User;
import com.miguelluque.apifirst.repository.RoleRepository;
import com.miguelluque.apifirst.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManageAuthServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private JwtTokenService jwtTokenService;

    @InjectMocks
    private ManageAuthService manageAuthService;

    @Test
    void registrationSuccessful() {
        // Configuración
        AuthRequest request = new AuthRequest("test@example.com", "password");
        Role role = new Role(1L, "ROLE_CUSTOMER");
        User user = new User(1L, "test@example.com", new BCryptPasswordEncoder().encode("password"), new HashSet<>(List.of(role)));

        when(roleRepository.findByName("ROLE_CUSTOMER")).thenReturn(Optional.of(role));
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtTokenService.generateAccessToken(user)).thenReturn("token");

        // Ejecutar
        AuthResponse response = manageAuthService.registration(request);

        // Verificar
        assertNotNull(response);
        assertEquals("test@example.com", response.getEmail());
        assertEquals("token", response.getToken());
        verify(userRepository, times(1)).findByEmail("test@example.com");
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void registrationUserExists() {
        // Configuración
        AuthRequest request = new AuthRequest("existing@example.com", "password");
        User existingUser = new User(1L, "existing@example.com", "password", new HashSet<>());

        when(userRepository.findByEmail("existing@example.com")).thenReturn(Optional.of(existingUser));

        // Ejecutar y Verificar
        assertThrows(AccessDeniedException.class, () -> manageAuthService.registration(request));

        verify(userRepository, times(1)).findByEmail("existing@example.com");
        verify(userRepository, never()).save(any(User.class));
    }

}
