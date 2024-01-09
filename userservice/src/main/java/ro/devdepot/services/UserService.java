package ro.devdepot.services;

import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.CreateUserRequest;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.LoginResponse;
import ro.devdepot.model.dto.UpdateUserRequest;
import ro.devdepot.model.dto.response.GetUserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public LoginResponse login(LoginRequest loginRequest);

    void createUser(CreateUserRequest createUserRequest);
    Long updateUser(UpdateUserRequest user, Long id);
    Long updateUserRole(String userRole, Long id);
    GetUserResponse getUserById(Long id);
    List<GetUserResponse> getAllUsers();
    void deleteUserById(Long id);

}
