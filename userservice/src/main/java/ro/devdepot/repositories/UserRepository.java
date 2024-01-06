package ro.devdepot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.devdepot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
