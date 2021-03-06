package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Model.Specality;
import guru.springframework.sfgpetclinic.Services.SpecalityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecalityServiceMap extends AbstractMapService<Specality, Long> implements SpecalityService {
    @Override
    public Set<Specality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specality object) {
        super.delete(object);
    }

    @Override
    public Specality save(Specality object) {
        return super.save(object);
    }

    @Override
    public Specality findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
