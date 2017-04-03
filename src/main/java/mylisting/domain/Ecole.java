package mylisting.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ecole {

    @NotNull
    @Size(min=2, max=24)
    private String ville;

    @NotNull
    @Size(min=2, max=48)
    private String nom;

    @Min(1)
    private int capaciteDAccueilMax;

    @NotNull
    @OneToMany(mappedBy = "ecole")
    private List<Classe> classes = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Ecole(String ville, String nom, int capaciteDAccueilMax) {
        this.ville = ville;
        this.nom = nom;
        this.capaciteDAccueilMax = capaciteDAccueilMax;
    }

    public Ecole() {

    }

    public void addClasse(Classe classe) {
        classes.add(classe);
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapaciteDAccueilMax() {
        return capaciteDAccueilMax;
    }

    public void setCapaciteDAccueilMax(int capaciteDAccueilMax) {
        this.capaciteDAccueilMax = capaciteDAccueilMax;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ecole{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", ville='" + getVille() + '\'' +
                ", capacité='" + getCapaciteDAccueilMax() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ecole that = (Ecole) o;

        if (!nom.equals(that.nom))
            return false;
        if (!ville.equals(that.ville))
            return false;
        return capaciteDAccueilMax == that.capaciteDAccueilMax;

    }

}
