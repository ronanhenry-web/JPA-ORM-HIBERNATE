package org.petstore;

import org.petstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Product product1 = new Product();
        product1.setCode("jouet");
        product1.setLabel("Jouet");
        product1.setType(ProdType.CLEANING);
        product1.setPrice(22.0);

        Product product2 = new Product();
        product2.setCode("niche");
        product2.setLabel("Niche");
        product2.setType(ProdType.ACCESSORY);
        product2.setPrice(202.0);

        Product product3 = new Product();
        product3.setCode("os");
        product3.setLabel("Os");
        product3.setType(ProdType.FOOD);
        product3.setPrice(7.0);

        em.persist(product1);
        em.persist(product2);
        em.persist(product3);

        Address address1 = new Address();
        address1.setNumber("27");
        address1.setStreet("Rue des mailles");
        address1.setCity("Rennes");
        address1.setZipCode("123");

        Address address2 = new Address();
        address2.setNumber("98");
        address2.setStreet("Rue des pygalles");
        address2.setCity("Paris");
        address2.setZipCode("456");

        Address address3 = new Address();
        address3.setNumber("78");
        address3.setStreet("Rue des grands");
        address3.setCity("Bordeaux");
        address3.setZipCode("789");

        em.persist(address1);
        em.persist(address2);
        em.persist(address3);

        PetStore petStore1 = new PetStore();
        petStore1.setNom("Cat Companies");
        petStore1.setManagerNom("Evan");
        petStore1.setAddress(address1);

        PetStore petStore2 = new PetStore();
        petStore2.setNom("Animalerie&Co");
        petStore2.setManagerNom("Johan");
        petStore2.setAddress(address2);

        PetStore petStore3 = new PetStore();
        petStore3.setNom("Dog Companies");
        petStore3.setManagerNom("Ronan");
        petStore3.setAddress(address3);

        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        Fish poisson1 = new Fish();
        poisson1.setFishlivenv(FishLivEnv.FRESH_WATER);
        poisson1.setBirth(LocalDate.now());
        poisson1.setCouleur("Orange");
        poisson1.setPetStore(petStore1);

        Fish poisson2 = new Fish();
        poisson2.setFishlivenv(FishLivEnv.SEA_WATER);
        poisson2.setBirth(LocalDate.now());
        poisson2.setCouleur("Bleu");
        poisson2.setPetStore(petStore2);

        Fish poisson3 = new Fish();
        poisson3.setFishlivenv(FishLivEnv.FRESH_WATER);
        poisson3.setBirth(LocalDate.now());
        poisson3.setCouleur("Rouge");
        poisson3.setPetStore(petStore3);

        em.persist(poisson1);
        em.persist(poisson2);
        em.persist(poisson3);

        Cat chat1 = new Cat();
        chat1.setChipId("147");
        chat1.setBirth(LocalDate.now());
        chat1.setCouleur("Gris");
        chat1.setPetStore(petStore1);

        Cat chat2 = new Cat();
        chat2.setChipId("258");
        chat2.setBirth(LocalDate.now());
        chat2.setCouleur("Blanc");
        chat2.setPetStore(petStore2);

        Cat chat3 = new Cat();
        chat3.setChipId("369");
        chat3.setBirth(LocalDate.now());
        chat3.setCouleur("Roux");
        chat3.setPetStore(petStore3);

        em.persist(chat1);
        em.persist(chat2);
        em.persist(chat3);

        petStore1.getProducts().add(product1);
        petStore1.getProducts().add(product2);

        petStore2.getProducts().add(product2);
        petStore2.getProducts().add(product3);

        petStore3.getProducts().add(product3);
        petStore3.getProducts().add(product1);

        // Requête pour afficher un petStore dans le terminal
        String query = "SELECT a FROM AbstractAnimal a JOIN a.petStore p WHERE p.id = :IdPetStore";
        List<AbstractAnimal> animals = em.createQuery(query, AbstractAnimal.class)
                // id du Store
                .setParameter("IdPetStore", 3L)
                .getResultList();

        for (AbstractAnimal animal : animals) {
            // instanceof vérifie si Cat appartient bien à animal
            if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println("Le chat est de couleur " + cat.getCouleur() + " et il est née le " + cat.getBirth());
            } else if (animal instanceof Fish) {
                Fish fish = (Fish) animal;
                System.out.println("Le poisson  vie dans le " + fish.getFishlivenv() + " et il est née le " + fish.getBirth());
            }
        }

        em.getTransaction().commit();
        // em = entityManagerFactory
        em.close();
        // emf = entityManager
        emf.close();
    }
}