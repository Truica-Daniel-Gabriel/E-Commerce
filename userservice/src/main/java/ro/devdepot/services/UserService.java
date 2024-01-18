package ro.devdepot.services;

import ro.devdepot.model.dto.response.AuthenticationResponse;
import ro.devdepot.model.dto.request.CreateUserRequest;
import ro.devdepot.model.dto.request.LoginRequest;
import ro.devdepot.model.dto.request.UpdateUserRequest;
import ro.devdepot.model.dto.response.GetUserResponse;

import java.util.List;

public interface UserService {
    AuthenticationResponse login(LoginRequest loginRequest);
    void createUser(CreateUserRequest createUserRequest);
    Long updateUser(UpdateUserRequest user, Long id);
    Long updateUserRole(String userRole, Long id);
    GetUserResponse getUserById(Long id);
    List<GetUserResponse> getAllUsers();
    void deleteUserById(Long id);

}
