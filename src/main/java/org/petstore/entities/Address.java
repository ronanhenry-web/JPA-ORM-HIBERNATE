package org.petstore.entities;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZipCODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;

    @OneToOne(mappedBy = "address")
    private PetStore petStore; // référence vers petStore

    public Address() {
    }

    public Address(Long id, String number, String street, String zipCode, String city, PetStore petStore) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.petStore = petStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
