package com.abderahman.booknetwork.auth;

import com.abderahman.booknetwork.email.EmailService;
import com.abderahman.booknetwork.role.RoleRepo;
import com.abderahman.booknetwork.user.Token;
import com.abderahman.booknetwork.user.TokenRepo;
import com.abderahman.booknetwork.user.User;
import com.abderahman.booknetwork.user.UserRepo;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final TokenRepo tokenRepo;
    private final EmailService emailService;
    @Value("${application.security.mailing.front.activation-url}")
    private String activationUrl;

    public void register(RegistrationRequest request) throws MessagingException {
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
        sendValidationEmail(user);


    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        // send email

             String confirmationUrl = "http://localhost:8080/api/v1/auth/activate?token=" + newToken + "&email=" + user.getEmail();
            emailService.sendEmail(
                user.getEmail(),
                user.getFullName(),
                "Book Network - Account Activation",
                com.abderahman.booknetwork.email.EmailTemplate.ACCOUNT_ACTIVATION,
                newToken,
                confirmationUrl
            );

    }

    private String generateAndSaveActivationToken(User user) {
        // generate a token
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(17))
                .user(user)
                .build();
        tokenRepo.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder activationCode = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            activationCode.append(characters.charAt(random.nextInt(characters.length())));
        }
        return activationCode.toString();
    }

}
