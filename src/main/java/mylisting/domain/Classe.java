package mylisting.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Classe {

    @NotNull
    @ManyToOne
    private Ecole ecole;

    @NotNull
    private Niveau niveau;

    @NotNull
    private String nomProfesseur;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Classe(Ecole ecole, Niveau niveau, String nomProfesseur) {
        this.ecole = ecole;
        this.niveau = niveau;
        this.nomProfesseur = nomProfesseur;
    }

    public Classe() {

    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public String getNomProfesseur() {
        return nomProfesseur;
    }

    public void setNomProfesseur(String nomProfesseur) {
        this.nomProfesseur = nomProfesseur;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + getId() +
                ", niveau='" + getNiveau() + '\'' +
                ", enseignant-e='" + getNomProfesseur() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classe that = (Classe) o;

        if (!ecole.equals(that.ecole))
            return false;
        if (!nomProfesseur.equals(that.nomProfesseur))
            return false;
        return niveau.equals(that.niveau);

    }

}
