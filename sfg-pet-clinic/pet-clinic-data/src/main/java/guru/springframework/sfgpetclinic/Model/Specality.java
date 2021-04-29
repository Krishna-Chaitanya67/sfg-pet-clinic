package guru.springframework.sfgpetclinic.Model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "specalities")
public class Specality extends BaseEntity{

    @Column(name = "description")
    private String Description;

}
