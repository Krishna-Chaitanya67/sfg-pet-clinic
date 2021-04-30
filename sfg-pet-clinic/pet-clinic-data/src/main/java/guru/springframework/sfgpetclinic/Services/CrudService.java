package guru.springframework.sfgpetclinic.Services;

import guru.springframework.sfgpetclinic.Model.BaseEntity;

import java.util.Set;

public interface CrudService <T extends BaseEntity, ID>{

    Set<T> findAll();

    T findByID(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

}
