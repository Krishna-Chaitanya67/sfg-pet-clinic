package guru.springframework.sfgpetclinic.Services;

import guru.springframework.sfgpetclinic.Model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(long id);

    Vet save(Vet pet);

    Set<Vet> findAll();
}
