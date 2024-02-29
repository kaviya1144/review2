package com.example.masala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.masala.model.Customer;
import com.example.masala.model.CustomerDetails;
import com.example.masala.service.CustomerDetailsService;
import com.example.masala.service.CustomerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @PostMapping("/postVal")
    public ResponseEntity<Customer> post(@RequestBody Customer customer) {

        try {
            return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<CustomerDetails> post1(@RequestBody CustomerDetails customerDetails) {

        try {
            return new ResponseEntity<>(customerDetailsService.create(customerDetails), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/get")
    public ResponseEntity<List<Customer>> getAllJob() {
        List<Customer> job = customerService.getAllJobs();
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping("/api/Customer/{id}")
    public ResponseEntity<Customer> getById(@PathVariable int id) {
        Customer job = customerService.getJobId(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("page/{offset}/{pageSize}")
    public Page <Customer> customerPagination(@PathVariable int offset,@PathVariable int pageSize){
        return customerService.customerPagination(offset, pageSize);
    }

    @GetMapping("sort/{field}")
    public List<Customer> customerSort(@PathVariable String field) {
        return customerService.customerSort(field);
    }
    
}
