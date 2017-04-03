package mylisting.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by 21301646 on 03/04/2017.
 */
@Entity
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull @Size(min = 2, max = 24)
    String nom;

    @NotNull @Size(min = 2, max = 24)
    String prenom;

    @Min(5)
    Integer age;

    @ManyToOne
    Classe classe;

    public Eleve() {
    }

    public Eleve(String nom, String prenom, Integer age, Classe classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.classe = classe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
