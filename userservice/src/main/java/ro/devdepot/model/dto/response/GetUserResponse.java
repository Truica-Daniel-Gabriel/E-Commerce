package ro.devdepot.model.dto.response;

import lombok.*;
import ro.devdepot.model.UserRole;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserResponse {
    private Long id;
    private String username;
    private String email;
    private String lastName;
    private String userRole;
    private String firstName;
}
