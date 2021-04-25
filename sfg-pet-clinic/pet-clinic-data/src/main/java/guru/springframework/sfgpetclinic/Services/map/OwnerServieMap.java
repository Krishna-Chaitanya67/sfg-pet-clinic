package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.Services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServieMap extends AbstractMapService<Owner, Long> implements OwnerService {
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
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public Owner findByLastName(String name) {
        return null;
    }
}
