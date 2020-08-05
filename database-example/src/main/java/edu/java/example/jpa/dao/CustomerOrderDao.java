package edu.java.example.jpa.dao;

import edu.java.example.jpa.view.CustomerOrderRequest;
import edu.java.example.jpa.view.CustomerOrderResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CustomerOrderDao {
    private EntityManager entityManager;

    public CustomerOrderDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        entityManager = emf.createEntityManager();
    }

    public List<CustomerOrderResponse> findCustomerOrder(CustomerOrderRequest request) {
        return null;
    }
}
