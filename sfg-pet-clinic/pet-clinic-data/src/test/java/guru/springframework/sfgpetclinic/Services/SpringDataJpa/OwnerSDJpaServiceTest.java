package guru.springframework.sfgpetclinic.Services.SpringDataJpa;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.cert.PKIXRevocationChecker;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName("krishna").build();
    }

    @Test
    void findAll() {
        Set<Owner> ownersReturnSet = new HashSet<>();
        ownersReturnSet.add(Owner.builder().id(1L).build());
        ownersReturnSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(ownersReturnSet);
        assertEquals(2, service.findAll().size());
    }

    @Test
    void findByID() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        assertEquals(returnOwner,service.findByID(1L));

    }

    @Test
    void save() {
        when(ownerRepository.save(returnOwner)).thenReturn((returnOwner));
        assertEquals(returnOwner,service.save(returnOwner));
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void findByLastName() {
        Owner returOwner = Owner.builder().id(1L).lastName("smith").build();
        when(ownerRepository.findByLastName(any())).thenReturn(returOwner);
        Owner smith = service.findByLastName("smith");
        assertEquals("smith",smith.getLastName());

    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}