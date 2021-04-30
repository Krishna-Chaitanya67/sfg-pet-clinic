package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServieMapTest {

    OwnerServieMap ownerServieMap;
    final Long ownerId = 1L;
    final String lastName = "Krishna";
    @BeforeEach
    void setUp() {
        ownerServieMap = new OwnerServieMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServieMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
       Set<Owner> owners =  ownerServieMap.findAll();
       assertEquals(1, owners.size());
    }

    @Test
    void findByID() {
        Owner owner = ownerServieMap.findByID(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner owner2 = Owner.builder().id(2l).build();
        ownerServieMap.save(owner2);
        Set<Owner> owners =  ownerServieMap.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        ownerServieMap.delete(ownerServieMap.findByID(ownerId));
        Set<Owner> owners =  ownerServieMap.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void deleteById() {
        ownerServieMap.deleteById(ownerId);
        Set<Owner> owners =  ownerServieMap.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void findByLastName() {
        Owner owner= ownerServieMap.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }
}