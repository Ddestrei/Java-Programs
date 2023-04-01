package org.ddestrei.auth;

import lombok.RequiredArgsConstructor;
import org.ddestrei.config.JwtService;
import org.ddestrei.domain.Role;
import org.ddestrei.domain.User;
import org.ddestrei.domain.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest register){
        var user = User.builder()
                .firstname(register.getFirstName())
                .lastname(register.getLastName())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest register){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        register.getEmail(),
                        register.getPassword()
                )
        );
        var user = userRepository.findByEmail(register.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
