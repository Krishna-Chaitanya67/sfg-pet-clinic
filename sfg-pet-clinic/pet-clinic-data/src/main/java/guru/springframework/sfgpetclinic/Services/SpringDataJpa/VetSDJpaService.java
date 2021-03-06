package guru.springframework.sfgpetclinic.Services.SpringDataJpa;

import guru.springframework.sfgpetclinic.Model.Vet;
import guru.springframework.sfgpetclinic.Services.VetService;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("springdatapa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findByID(Long aLong) {
        Optional<Vet> optionalVetId =vetRepository.findById(aLong);
        return optionalVetId.orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
