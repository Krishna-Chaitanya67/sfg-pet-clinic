package guru.springframework.sfgpetclinic.Services.map;


import guru.springframework.sfgpetclinic.Model.Specality;
import guru.springframework.sfgpetclinic.Model.Vet;
import guru.springframework.sfgpetclinic.Services.SpecalityService;
import guru.springframework.sfgpetclinic.Services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecalityService specalityService;

    public VetServiceMap(SpecalityService specalityService) {
        this.specalityService = specalityService;
    }

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
        if(object.getSpecalities().size() >0){
            object.getSpecalities().forEach(specality -> {
                if(specality.getId() == null){
                    Specality savedSepaclity = specalityService.save(specality);
                    specality.setId(savedSepaclity.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
