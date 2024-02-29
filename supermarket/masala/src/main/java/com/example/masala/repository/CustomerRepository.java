package com.example.masala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.masala.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
