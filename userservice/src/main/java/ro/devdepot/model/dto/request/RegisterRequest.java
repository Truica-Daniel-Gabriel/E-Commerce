package ro.devdepot.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message = "Username it's required")
    private String username;
    @NotBlank(message = "Password it's required")
    private String password;
    @NotBlank(message = "Email it's required")
    private String email;

}
