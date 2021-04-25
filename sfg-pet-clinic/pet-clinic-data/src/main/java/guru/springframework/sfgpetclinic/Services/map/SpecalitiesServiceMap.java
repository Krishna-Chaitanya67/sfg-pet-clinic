package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Model.Specality;
import guru.springframework.sfgpetclinic.Services.SpecalitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecalitiesServiceMap extends AbstractMapService<Specality, Long> implements SpecalitiesService {
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
    void deleteByID(Long id) {
        super.deleteByID(id);
    }
}
