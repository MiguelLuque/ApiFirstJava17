package com.miguelluque.apifirst.usecase;

import com.miguelluque.apifirst.dto.AuthRequest;
import com.miguelluque.apifirst.dto.AuthResponse;
import com.miguelluque.apifirst.entity.Role;
import com.miguelluque.apifirst.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface ManageAuthUseCase {

    AuthResponse login(User user);

    AuthResponse registration(AuthRequest authRequest);

    Role findRoleByName(String name);

    UserDetails loadUserByEmail(String email);
}
