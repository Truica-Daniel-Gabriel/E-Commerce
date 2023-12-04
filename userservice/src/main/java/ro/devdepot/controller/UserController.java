package ro.devdepot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.devdepot.controller.swagger.UserControllerSwaggerDoc;
import ro.devdepot.model.User;
import ro.devdepot.model.dto.CreateUserRequest;
import ro.devdepot.model.dto.LoginRequest;
import ro.devdepot.model.dto.UpdateUserRequest;
import ro.devdepot.model.dto.UpdateUserRoleRequest;
import ro.devdepot.model.dto.response.GetUserResponse;
import ro.devdepot.services.UserService;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerSwaggerDoc {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public void login(LoginRequest loginRequest) {

    }

    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody @Valid CreateUserRequest createUserRequest) {

        return new ResponseEntity<>(userService.createUser(createUserRequest), HttpStatus.CREATED);
    }
    @PutMapping("/updateUser/{id}")
    ResponseEntity<String> updateUser(@RequestBody @Valid UpdateUserRequest updateUserRequest, @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(userService.updateUser(updateUserRequest, id), HttpStatus.OK);
    }

    @PatchMapping("/updateUserrole/{id}")
    ResponseEntity<String> updateUserRole(@RequestBody UpdateUserRoleRequest userRole,
                                          @PathVariable(name = "id") Long id) {

        return new ResponseEntity<>(userService.updateUserRole(userRole.getUserrole(), id), HttpStatus.OK);
    }
    @GetMapping("/getUser/{id}")
    ResponseEntity<GetUserResponse> getUser(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    ResponseEntity<List<GetUserResponse>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
    }
}
