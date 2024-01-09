package ro.devdepot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.devdepot.controller.swagger.UserControllerSwaggerDoc;
import ro.devdepot.model.dto.AuthenticationResponse;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.RegisterRequest;
import ro.devdepot.services.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController implements UserControllerSwaggerDoc {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest user) {
        return ResponseEntity.ok(userService.login(user));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register( @RequestBody RegisterRequest user) {
        return ResponseEntity.ok(userService.register(user));
    }

}
