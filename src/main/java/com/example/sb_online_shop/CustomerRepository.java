package com.example.sb_online_shop;

import org.springframework.data.repository.CrudRepository;

import com.example.sb_online_shop.domain.Customer;


    public interface CustomerRepository extends CrudRepository<Customer, Long> {

        
    }

