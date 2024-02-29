package com.example.masala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masala.model.CustomerDetails;
import com.example.masala.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsService {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetails create(CustomerDetails customerDetails) {
        return customerDetailsRepository.save(customerDetails);
    }
}
