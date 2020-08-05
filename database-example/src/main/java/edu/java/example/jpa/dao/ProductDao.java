package edu.java.example.jpa.dao;

import edu.java.example.jpa.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDao {
    private EntityManager entityManager;

    public ProductDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        entityManager = emf.createEntityManager();
    }

    public List<Product> findProduct() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

}
