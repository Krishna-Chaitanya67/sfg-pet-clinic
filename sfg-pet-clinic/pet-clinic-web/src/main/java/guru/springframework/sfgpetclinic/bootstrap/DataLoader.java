package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.Model.*;
import guru.springframework.sfgpetclinic.Services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petService;
    private final SpecalityService specalityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petService, SpecalityService specalityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.specalityService = specalityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count =petService.findAll().size();
        if(count ==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petService.save(cat);

        Specality radiology = new Specality();
        radiology.setDescription("Radiology");
        Specality savedRadiology = specalityService.save(radiology);

        Specality surgery = new Specality();
        surgery.setDescription("Surgery");
        Specality savedSurgery = specalityService.save(surgery);

        Specality dentistry = new Specality();
        dentistry.setDescription("Dentistry");
        Specality savedDentistry = specalityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Krishna");
        owner1.setLastName("Balanagu");
        owner1.setAddress("Attiguppe");
        owner1.setCity("Bangalore");
        owner1.setTelephone("4476946");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Rosco");
        mikesPet.setBirthDate(LocalDate.now());

        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Chaitanya");
        owner2.setLastName("Balanagus");
        owner2.setAddress("Attigupper");
        owner2.setCity("Bangalore");
        owner2.setTelephone("4476946");

        Pet cksPet = new Pet();
        cksPet.setPetType(savedCatPetType);
        cksPet.setOwner(owner2);
        cksPet.setName("Grump");
        cksPet.setBirthDate(LocalDate.now());

        owner2.getPets().add(cksPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(cksPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        System.out.println("Owners Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mark");
        vet1.setLastName("Twain");
        vet1.getSpecalities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sherlock");
        vet2.setLastName("Holmes");
        vet2.getSpecalities().add(savedSurgery);

        vetService.save(vet2);
        System.out.println("Vets loaded");
    }
}
