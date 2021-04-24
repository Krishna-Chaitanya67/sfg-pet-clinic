package guru.springframework.sfgpetclinic.Services.map;


import guru.springframework.sfgpetclinic.Model.Vet;
import guru.springframework.sfgpetclinic.Services.CrudService;
import guru.springframework.sfgpetclinic.Services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    void deleteByID(Long id) {
        super.deleteByID(id);
    }
}
