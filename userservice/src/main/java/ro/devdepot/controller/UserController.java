package ro.devdepot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.devdepot.controller.swagger.UserControllerSwaggerDoc;
import ro.devdepot.model.dto.request.UpdateUserRequest;
import ro.devdepot.model.dto.request.UpdateUserRoleRequest;
import ro.devdepot.model.dto.response.GetUserResponse;
import ro.devdepot.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController implements UserControllerSwaggerDoc {

    private final UserService userService;


    @PutMapping("/updateUser/{id}")
    ResponseEntity<String> updateUser(@RequestBody @Valid UpdateUserRequest updateUserRequest,
                                      @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>( "User " + userService.updateUser(updateUserRequest, id) + " has been saved successfully", HttpStatus.OK);
    }

    @PatchMapping("/updateUserRole/{id}")
    ResponseEntity<String> updateUserRole(@RequestBody UpdateUserRoleRequest userRole,
                                          @PathVariable(name = "id") Long id) {

        return new ResponseEntity<>(userService.updateUserRole(userRole.getUserRole(), id)  + " user role has been successfully updated", HttpStatus.OK);
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
            userService.deleteUserById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
