package edu.java.example.jpa.dao;

import edu.java.example.jpa.domain.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoTest {

    @Test
    public void findProduct() {
        ProductDao dao = new ProductDao();
        dao.findProduct().forEach(p -> System.out.println(p));
    }
}