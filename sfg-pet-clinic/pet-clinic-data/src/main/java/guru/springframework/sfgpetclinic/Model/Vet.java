package guru.springframework.sfgpetclinic.Model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{

    private Set<Specality> specalities = new HashSet<>();

    public Set<Specality> getSpecalities() {
        return specalities;
    }

    public void setSpecalities(Set<Specality> specalities) {
        this.specalities = specalities;
    }
}
