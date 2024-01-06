package ro.devdepot.services.implementation;

import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.AuthenticationResponse;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.RegisterRequest;
import ro.devdepot.repositories.UserRepository;
import ro.devdepot.services.JwtService;
import ro.devdepot.services.UserService;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                      loginRequest.getUsername(),
                      loginRequest.getPassword()
                )
        );
        var user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .jsonToken(jwtToken)
                .username(user.getUsername())
                .build();
    }

    @Override
    public AuthenticationResponse register(RegisterRequest user) {
        User savedUser = User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .userRole(UserRole.USER)
                .build();
        userRepository.save(savedUser);
        var jwtToken = jwtService.generateToken(savedUser);
        return AuthenticationResponse.builder()
                .jsonToken(jwtToken)
                .username(savedUser.getUsername())
                .build();
    }
}
