package com.example.masala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.masala.model.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {

}
