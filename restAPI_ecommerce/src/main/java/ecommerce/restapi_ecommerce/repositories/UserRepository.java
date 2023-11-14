package ecommerce.restapi_ecommerce.repositories;

import ecommerce.restapi_ecommerce.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
