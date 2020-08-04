package edu.java.example.jpa.domain;

import java.util.List;

public class CustomerBasket {
   private Customer customer;
   private List<Item> customerItems;

    public CustomerBasket() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getCustomerItems() {
        return customerItems;
    }

    public void setCustomerItems(List<Item> customerItems) {
        this.customerItems = customerItems;
    }
}
