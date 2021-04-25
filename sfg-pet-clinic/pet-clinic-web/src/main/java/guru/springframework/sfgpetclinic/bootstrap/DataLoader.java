package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.Model.PetType;
import guru.springframework.sfgpetclinic.Model.Vet;
import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.PetTypeService;
import guru.springframework.sfgpetclinic.Services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Krishna");
        owner1.setLastName("Balanagu");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Chaitanya");
        owner2.setLastName("Balanagu");

        ownerService.save(owner2);
        System.out.println("Owners Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mark");
        vet1.setLastName("Twain");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sherlock");
        vet2.setLastName("Holmes");

        vetService.save(vet2);
        System.out.println("Vets loaded");
    }
}
