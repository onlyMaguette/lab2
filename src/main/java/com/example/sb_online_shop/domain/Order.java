package com.example.sb_online_shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {
    }

    public Order( double total, Customer customer) {
        super();
        this.total = total;
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
