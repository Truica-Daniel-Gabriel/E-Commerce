package ro.devdepot.services;

import ro.devdepot.model.User;
import ro.devdepot.model.UserRole;
import ro.devdepot.model.dto.CreateUserRequest;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.LoginResponse;
import ro.devdepot.model.dto.UpdateUserRequest;
import ro.devdepot.model.dto.response.GetUserResponse;

import java.util.List;

public interface UserService {
    public LoginResponse login(LoginRequest loginRequest);

    void createUser(CreateUserRequest createUserRequest);
    String updateUser(UpdateUserRequest user, Long id);
    String updateUserRole(String userrole, Long id);
    GetUserResponse getUserById(Long id);
    List<GetUserResponse> getAllUsers();
    String deleteUserById(Long id);

}
