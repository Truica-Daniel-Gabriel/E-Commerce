package ro.devdepot.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Could not be null")
    @Size(min = 5, message = "Your username must to have minimum 5 characters")
    private String username;

    @Size(min = 8, message = "Your password should have minimum 8 characters")
    @NotBlank(message = "You should have a password")
    private String password;
}
