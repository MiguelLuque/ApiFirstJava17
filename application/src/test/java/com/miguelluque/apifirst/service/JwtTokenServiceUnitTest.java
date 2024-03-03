package com.miguelluque.apifirst.service;

import com.miguelluque.apifirst.entity.Role;
import com.miguelluque.apifirst.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JwtTokenServiceUnitTest {


    private User user;

    @InjectMocks
    private JwtTokenService jwtTokenService;


    @BeforeEach
    void setUp() {
        // Configura un usuario de prueba
        user = User.builder()
                .id(1L)
                .email("test@example.com")
                .build();
        user.setRoles(Set.of(Role.builder().id(1L).name("ROLE_CUSTOMER").build()));

        ReflectionTestUtils.setField(this.jwtTokenService, "SECRET_KEY", "SECRETKEY2A2181281ABCD1232213ABABCDAHFDBD12");
    }

    @Test
    void generateAccessTokenReturnsToken() {
        String token = jwtTokenService.generateAccessToken(user);
        assertNotNull(token);
    }

    @Test
    void extractUsernameValidTokenReturnsUsername() {
        String token = jwtTokenService.generateAccessToken(user);
        String username = jwtTokenService.extractUsername(token);
        assertEquals("test@example.com", username);
    }

    @Test
    void validateTokenValidTokenReturnsTrue() {
        String token = jwtTokenService.generateAccessToken(user);
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername("test@example.com")
                .password("password")
                .authorities(new ArrayList<>())
                .build();

        assertTrue(jwtTokenService.validateToken(token, userDetails));
    }

}

