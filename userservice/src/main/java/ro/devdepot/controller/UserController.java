package ro.devdepot.controller;

import org.springframework.web.bind.annotation.RestController;
import ro.devdepot.controller.swagger.UserControllerSwaggerDoc;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.services.UserService;


@RestController
public class UserController implements UserControllerSwaggerDoc {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public void login(LoginRequest loginRequest) {

    }
}
