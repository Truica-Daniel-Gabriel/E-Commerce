package ro.devdepot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.devdepot.model.dto.response.AuthenticationResponse;
import ro.devdepot.model.dto.request.CreateUserRequest;
import ro.devdepot.model.dto.request.LoginRequest;
import ro.devdepot.model.dto.response.RegisterResponse;
import ro.devdepot.services.UserService;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid LoginRequest loginRequest) {

        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    ResponseEntity<RegisterResponse> register(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(userService.createUser(createUserRequest), HttpStatus.CREATED);
    }

}
