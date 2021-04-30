package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.Model.Pet;
import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.PetService;
import guru.springframework.sfgpetclinic.Services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServieMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServieMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object !=null){
            if(object.getPets() !=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() != null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else{
                        throw new RuntimeException("Pet Type is required");
                    } if(pet.getId() == null){
                        Pet savedpet = petService.save(pet);
                        pet.setId(savedpet.getId());
                    }
                });
            }
            return super.save(object);
        } else{
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {

        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
