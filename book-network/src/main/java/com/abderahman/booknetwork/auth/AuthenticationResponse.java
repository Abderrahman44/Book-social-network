package com.abderahman.booknetwork.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@Builder
public class AuthenticationResponse {

    private String token;
}
