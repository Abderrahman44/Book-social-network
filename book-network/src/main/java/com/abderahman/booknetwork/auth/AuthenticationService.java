package com.abderahman.booknetwork.auth;

import com.abderahman.booknetwork.role.RoleRepo;
import com.abderahman.booknetwork.user.User;
import com.abderahman.booknetwork.user.UserRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    public void register(RegistrationRequest request) {
        // assigned default role
        // create user obj
        // send validation email
        var userRole = roleRepo.findByName("USER")
                // todo - better exception hundling
                .orElseThrow(() -> new IllegalArgumentException("User Role was not initialized"));
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole)).build();
        userRepo.save(user);



    }

}
