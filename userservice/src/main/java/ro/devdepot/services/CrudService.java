package ro.devdepot.services;

import java.util.List;
import java.util.Set;

public interface CrudService <T, ID>{

    List<T> findAll();

    T findById(ID id);

    T save(T object);

    T updateUser(T object, ID id);

    void delete(T object);

    void deleteById(ID id);
}
