package ro.devdepot.services.implementation;


import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.LoginResponse;
import ro.devdepot.repositories.UserRepository;
import ro.devdepot.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User object) {
        User user = findById(object.getId());
        if(user == null){
            return userRepository.save(object);
        }
        throw  new EntityExistsException("This user already exist");
    }

    @Override
    public User updateUser(User updatedUser, Long id) {
        User existingUser = this.findById(id);
        if (existingUser == null){
            throw  new EntityNotFoundException("User not found");
        }
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setUserRole(updatedUser.getUserRole());
        return this.save(existingUser);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
