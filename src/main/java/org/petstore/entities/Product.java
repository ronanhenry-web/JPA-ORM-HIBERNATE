package org.petstore.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "TYPE")
    private ProdType type;
    @Column(name = "PRICE")
    private Double price;

    // fait référence vers petStore
    @ManyToMany(mappedBy="products")
    private Set<PetStore> petStores;

    public Product() {
    }

    public Product(Long id, String code, String label, ProdType type, Double price, Set<PetStore> petStores) {
        this.id = id;
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petStores = petStores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", petStores=" + petStores +
                '}';
    }
}
