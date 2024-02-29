package com.example.masala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.masala.model.Customer;
import com.example.masala.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllJobs() {
        return customerRepository.findAll();
    }

    public Customer getJobId(int jobId) {
        return customerRepository.findById(jobId).orElse(null);
    }
    public Page <Customer> customerPagination(int offset,int pageSize){
        return customerRepository.findAll(PageRequest.of(offset,pageSize));
    }
    public List<Customer> customerSort(String field) {
        return customerRepository.findAll(Sort.by(Sort.Direction.ASC,field)); 
    }
    public Page<Customer> customerPaginationSort(int offset,int pageSize, String field) {
        return customerRepository.findAll(PageRequest.of(offset, pageSize,Sort.by(Sort.Direction.ASC,field)));
    }
}
