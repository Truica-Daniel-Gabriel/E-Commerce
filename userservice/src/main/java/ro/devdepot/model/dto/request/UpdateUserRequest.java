package ro.devdepot.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    @Pattern(regexp = "[a-zA-Z0-9._]+@[a-z]+\\.[a-z]{2,4}$", message = "invalid email")
    private String email;

    @NotBlank(message = "You should put your first name")
    @Size(min = 3, message = "Minimum 3 characters for first name")
    private String firstName;

    @Size(min = 3, message = "Minimum 3 characters for last name")
    @NotBlank(message = "You should put your last name")
    private String lastName;
}
