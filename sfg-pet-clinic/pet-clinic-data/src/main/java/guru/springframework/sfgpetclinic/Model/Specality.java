package guru.springframework.sfgpetclinic.Model;

public class Specality extends BaseEntity{

    private String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
