package ro.devdepot.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "You should have an username")
    @Size(min = 5, message = "Your username must to have minimum 5 characters")
    private String username;
    @Size(min = 8, message = "Your password should have minimum 8 characters")
    @NotBlank(message = "You should have a password")
    private String password;
    @NotBlank(message = "You should have an email")
    @Pattern(regexp = "[a-zA-Z0-9._]+@[a-z]+\\.[a-z]{2,4}$", message = "invalid email")
    private String email;
    @Size(min = 3, message = "Minimum 3 characters for last name")
    @NotBlank(message = "You should have an last name")
    private String lastName;
    @Size(min = 3, message = "Minimum 3 characters for first name")
    @NotBlank(message = "You should have an first name")
    private String firstName;
}

