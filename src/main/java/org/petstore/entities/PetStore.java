package org.petstore.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "ManagerNOM")
    private String managerNom;

    // référence vers animal
    @OneToMany(mappedBy = "petStore", fetch = FetchType.EAGER)
    private Set<AbstractAnimal> Animals;

    @OneToOne
    private Address address; // référence vers l'adresse

    // classe d'association PRO_PS
    @ManyToMany
    @JoinTable(name="PRO_PS",
            joinColumns= @JoinColumn(name="ID_PS", referencedColumnName=
                    "ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PRO", referencedColumnName="ID")
    )
    private Set<Product> products = new HashSet<>(); // créer une collection

    public PetStore() {
    }

    public PetStore(Long id, String nom, String managerNom, Set<AbstractAnimal> animals, Address address, Set<Product> products) {
        this.id = id;
        this.nom = nom;
        this.managerNom = managerNom;
        Animals = animals;
        this.address = address;
        this.products = products;
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

    public String getManagerNom() {
        return managerNom;
    }

    public void setManagerNom(String managerNom) {
        this.managerNom = managerNom;
    }

    public Set<AbstractAnimal> getAnimals() {
        return Animals;
    }

    public void setAnimals(Set<AbstractAnimal> animals) {
        Animals = animals;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", managerNom='" + managerNom + '\'' +
                ", Animals=" + Animals +
                ", address=" + address +
                ", products=" + products +
                '}';
    }
}
