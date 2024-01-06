package ro.devdepot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.devdepot.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
