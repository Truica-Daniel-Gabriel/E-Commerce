package ro.devdepot.services;

import ro.devdepot.model.dto.AuthenticationResponse;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.RegisterRequest;

public interface UserService {
    public AuthenticationResponse login(LoginRequest loginRequest);

    public AuthenticationResponse register(RegisterRequest user);

}
