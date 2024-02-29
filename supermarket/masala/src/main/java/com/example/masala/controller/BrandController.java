package com.example.masala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.masala.model.Brand;
import com.example.masala.service.BrandService;


@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/postbybrand")
    public ResponseEntity<Brand> post(@RequestBody Brand brand) {

        try {
            return new ResponseEntity<>(brandService.create(brand), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/bybrandId/{brand_id}")
    public ResponseEntity<Brand> getById(@PathVariable int brand_id) {
        Brand b = brandService.getBrandId(brand_id);
        if (b != null) {
            return new ResponseEntity<>(b, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get/bybrandname/{brand_name}")
    public ResponseEntity <List<Brand>> getByName(@PathVariable String brand_name){
        List<Brand> b = brandService.getBrandName(brand_name);
        if(b!=null){
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
