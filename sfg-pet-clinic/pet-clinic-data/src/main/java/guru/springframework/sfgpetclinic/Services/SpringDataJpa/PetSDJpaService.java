package guru.springframework.sfgpetclinic.Services.SpringDataJpa;

import guru.springframework.sfgpetclinic.Model.Pet;
import guru.springframework.sfgpetclinic.Model.PetType;
import guru.springframework.sfgpetclinic.Services.PetService;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("springdatapa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findByID(Long aLong) {
        Optional<Pet> optionalPetId =petRepository.findById(aLong);
        return optionalPetId.orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
