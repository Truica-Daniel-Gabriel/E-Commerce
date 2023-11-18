package ro.devdepot.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class LoginResponse {
    private String username;
    private String jsonToken;
}
