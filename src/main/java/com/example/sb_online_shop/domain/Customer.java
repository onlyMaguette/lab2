package com.example.sb_online_shop.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import java.util.List;


@Entity
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String fullname;

        private String city;

        private double balance;

        public Customer() {
        }

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders;
    
    

    public Customer(String fullname, String city, double balance) {
        super();
        this.fullname = fullname;
        this.city = city;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCity() {
        return city;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



}
