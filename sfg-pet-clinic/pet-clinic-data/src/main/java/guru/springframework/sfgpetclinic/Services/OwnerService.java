package guru.springframework.sfgpetclinic.Services;

import guru.springframework.sfgpetclinic.Model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String name);

    List<Owner> findAllByLastNameLike(String lastName);

}
