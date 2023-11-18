package ro.devdepot.controller.swagger;

import org.springframework.http.ResponseEntity;
import ro.devdepot.model.User;

import java.util.List;

public interface UserControllerSwaggerDoc {

//    @Model( example = """
//            {json
//
//            }
//            """)
    public ResponseEntity<List<User>> getUsers();
}
