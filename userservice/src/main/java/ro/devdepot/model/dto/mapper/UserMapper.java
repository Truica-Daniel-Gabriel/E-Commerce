package ro.devdepot.model.dto.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.CreateUserRequest;
import ro.devdepot.model.dto.UpdateUserRequest;

@Service
public class UserMapper {

    public User getUserFrom(CreateUserRequest createUserRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);
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
