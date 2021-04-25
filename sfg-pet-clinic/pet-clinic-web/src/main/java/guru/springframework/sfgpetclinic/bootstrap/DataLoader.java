package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.Model.Vet;
import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.VetService;
import guru.springframework.sfgpetclinic.Services.map.OwnerServieMap;
import guru.springframework.sfgpetclinic.Services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Krishna");
        owner1.setLastName("Balanagu");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Chaitanya");
        owner2.setLastName("Balanagu");

        ownerService.save(owner2);
        System.out.println("Owners Loaded");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Mark");
        vet1.setLastName("Twain");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("Sherlock");
        vet2.setLastName("Holmes");

        vetService.save(vet2);
        System.out.println("Vets loaded");
    }
}
