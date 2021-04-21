package guru.springframework.sfgpetclinic.Services;

import java.util.Set;

public interface CrudService <T, ID>{

    Set<T> findAll();

    T findByID(ID id);

    T save(T object);

    void delete(ID id);
}
