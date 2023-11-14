package e_commerce.restAPI_ecommerce.repositories;

import e_commerce.restAPI_ecommerce.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
