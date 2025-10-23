package epsi.b3.projet_asso.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;

@Entity
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;

    public Membre(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @OneToMany(mappedBy = "membre")
    private List<Statut> statuts;

    // @OneToOne(mappedBy = "evenement")
    // private Evenement evenement;

    public Long getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }
}
