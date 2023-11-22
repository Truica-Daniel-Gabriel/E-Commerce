package ro.devdepot.services.implementation;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.LoginResponse;
import ro.devdepot.repositories.UserRepository;
import ro.devdepot.services.UserService;

import java.util.List;
import java.util.Optional;


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

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        User existingUser = userRepository.findById(id).orElse(null);

        existingUser.setUsername(user.getUsername());

        return userRepository.save(existingUser);
    }

    @Override
    public User updateUserRole(UserRole newuserRole, Long id) {
        User existingUser = userRepository.findById(id).orElse(null);

        existingUser.setUserRole(newuserRole);

        return userRepository.save(existingUser);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
