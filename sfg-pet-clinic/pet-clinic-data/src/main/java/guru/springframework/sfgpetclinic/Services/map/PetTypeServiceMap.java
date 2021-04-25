package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Model.PetType;
import guru.springframework.sfgpetclinic.Services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }
    @Override
    public PetType findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
    @Override
    public void deleteByID(Long id){
        super.deleteByID(id);
    }
}