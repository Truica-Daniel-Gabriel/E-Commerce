package ro.devdepot.services;

import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.LoginResponse;

import java.util.List;

public interface UserService {
    public LoginResponse login(LoginRequest loginRequest);

    User createUser(User user);
    User updateUser(User user, Long id);
    User updateUserRole(UserRole userRole, Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUserById(Long id);

}
