package edu.java.example.jpa.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "jpa_customer_order")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER,
    mappedBy = "order")
    private List<CustomerOrderItem> items;
    @Column(name = "status")
    private OrderStatus status;

    public CustomerOrder() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CustomerOrderItem> getItems() {
        return items;
    }

    public void setItems(List<CustomerOrderItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
