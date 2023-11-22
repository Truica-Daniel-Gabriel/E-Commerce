package ro.devdepot.services;

import ro.devdepot.model.User;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.LoginResponse;

public interface UserService {
    public LoginResponse login(LoginRequest loginRequest);
}
