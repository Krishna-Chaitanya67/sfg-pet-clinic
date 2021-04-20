package guru.springframework.sfgpetclinic.Services;

import guru.springframework.sfgpetclinic.Model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(long id);

    Owner findByName(String name);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
