package ro.devdepot.services.implementation;

import org.springframework.stereotype.Service;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.LoginResponse;
import ro.devdepot.repositories.UserRepository;
import ro.devdepot.services.UserService;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // User user = repository.getUserByUsername(loginRequest.getUsername);
        // encodedPassword =.... loginRequest.getPass
        // iff user.getPassword.equals(encodedPassword)
        // tokenService.getJWT(user)
        // build new LoginResponse -> username, jwt
        // if user.getRole.euals(UserRole.ADMIN)

        return null;
    }
}
