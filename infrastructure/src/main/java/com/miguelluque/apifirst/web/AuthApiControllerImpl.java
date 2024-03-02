package com.miguelluque.apifirst.web;

import com.miguelluque.apifirst.api.AuthApi;
import com.miguelluque.apifirst.dto.AuthRequest;
import com.miguelluque.apifirst.dto.AuthResponse;
import com.miguelluque.apifirst.entity.User;
import com.miguelluque.apifirst.service.ManageAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthApiControllerImpl implements AuthApi {

    private final ManageAuthService manageAuthService;

    private final AuthenticationManager authManager;

    @Override
    public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(), authRequest.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok().body(manageAuthService.login(user));
    }

    @Override
    public ResponseEntity<AuthResponse> registration(AuthRequest authRequest) {
        return ResponseEntity.ok().body(manageAuthService.registration(authRequest));
    }

}
