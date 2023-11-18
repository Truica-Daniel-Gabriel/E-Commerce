package ro.devdepot.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class LoginRequest {
    private String username;
    private String password;
    private boolean keepMeLoggedIn;
}
