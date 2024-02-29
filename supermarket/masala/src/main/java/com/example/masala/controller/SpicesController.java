package com.example.masala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.masala.model.Spices;
import com.example.masala.service.SpicesService;

@RestController
public class SpicesController {
    
     @Autowired
    private SpicesService spicesService;

    @PostMapping("/postbyspices")
    public ResponseEntity<Spices> post(@RequestBody Spices spices) {

        try {
            return new ResponseEntity<>(spicesService.createspice(spices), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/byspiceId/{id}")
    public ResponseEntity<Spices> getById(@PathVariable int id) {
        Spices b = spicesService.getSpiceId(id);
        if (b != null) {
            return new ResponseEntity<>(b, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/updateprice/{id}")
    public ResponseEntity<Void> put(@PathVariable int id, @RequestParam int price) {
        spicesService.putSpices(id, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
