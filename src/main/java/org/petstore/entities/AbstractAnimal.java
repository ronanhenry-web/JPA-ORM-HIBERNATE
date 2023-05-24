package org.petstore.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DATE")
    private LocalDate birth;
    @Column(name = "COULEUR")
    private String couleur;

    @ManyToOne
    @JoinColumn(name="PET_ID")
    private PetStore petStore;

    public AbstractAnimal() {
    }

    public AbstractAnimal(Long id, LocalDate birth, String couleur, PetStore petStore) {
        this.id = id;
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}
