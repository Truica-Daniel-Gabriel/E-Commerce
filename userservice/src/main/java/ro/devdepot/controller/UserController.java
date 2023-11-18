package ro.devdepot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.devdepot.controller.swagger.UserControllerSwaggerDoc;
import ro.devdepot.model.User;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.services.UserService;

import java.util.List;

@RestController
public class UserController implements UserControllerSwaggerDoc {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
    public void login(LoginRequest loginRequest) {

    }
}
