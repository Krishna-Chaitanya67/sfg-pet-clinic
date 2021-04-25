package guru.springframework.sfgpetclinic.Model;

import java.util.Set;

public class Vet extends Person{

    private Set<Specality> specalities;

    public Set<Specality> getSpecalities() {
        return specalities;
    }

    public void setSpecalities(Set<Specality> specalities) {
        this.specalities = specalities;
    }
}
