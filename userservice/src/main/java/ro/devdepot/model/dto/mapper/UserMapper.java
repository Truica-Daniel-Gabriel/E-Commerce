package ro.devdepot.model.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.request.CreateUserRequest;

@RequiredArgsConstructor
@Service
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public User getUserFrom(CreateUserRequest createUserRequest) {

        return User
                .builder()
                .username(createUserRequest.getUsername())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .email(createUserRequest.getEmail())
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .userRole(UserRole.USER)
                .build();
    }
}
