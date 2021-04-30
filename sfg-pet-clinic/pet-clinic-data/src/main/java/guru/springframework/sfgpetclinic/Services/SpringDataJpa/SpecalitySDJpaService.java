package guru.springframework.sfgpetclinic.Services.SpringDataJpa;

import guru.springframework.sfgpetclinic.Model.Specality;
import guru.springframework.sfgpetclinic.Services.SpecalityService;
import guru.springframework.sfgpetclinic.repositories.SpecalityRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("springdatapa")
public class SpecalitySDJpaService implements SpecalityService {

    private final SpecalityRepository specalityRepository;

    public SpecalitySDJpaService(SpecalityRepository specalityRepository) {
        this.specalityRepository = specalityRepository;
    }


    @Override
    public Set<Specality> findAll() {
        Set<Specality> specalities = new HashSet<>();
        specalityRepository.findAll().forEach(specalities::add);
        return specalities;
    }

    @Override
    public Specality findByID(Long aLong) {
        Optional<Specality> specalityId = specalityRepository.findById(aLong);
        return specalityId.orElse(null);
    }

    @Override
    public Specality save(Specality object) {
        return specalityRepository.save(object);
    }

    @Override
    public void delete(Specality object) {
        specalityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specalityRepository.deleteById(id);
    }
}
