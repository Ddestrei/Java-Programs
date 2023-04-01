package org.ddestrei.auth;

import lombok.RequiredArgsConstructor;
import org.ddestrei.config.JwtService;
import org.ddestrei.entites.Roles;
import org.ddestrei.entites.User;
import org.ddestrei.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest){
        var user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Roles.STUDENT)
                .build();
        userService.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse().builder()
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
        var user = userService.findByEmail(register.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
