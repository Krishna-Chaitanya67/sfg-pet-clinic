package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.Model.Specality;
import org.springframework.data.repository.CrudRepository;

public interface SpecalityRepository extends CrudRepository<Specality, Long> {
}
