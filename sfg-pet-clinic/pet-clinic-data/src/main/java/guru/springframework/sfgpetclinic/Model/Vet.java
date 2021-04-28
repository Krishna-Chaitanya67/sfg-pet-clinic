package guru.springframework.sfgpetclinic.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specalities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specality_id"))
    private Set<Specality> specalities = new HashSet<>();

    public Set<Specality> getSpecalities() {
        return specalities;
    }

    public void setSpecalities(Set<Specality> specalities) {
        this.specalities = specalities;
    }
}
