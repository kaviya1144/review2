package com.example.masala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.masala.model.Brand;
import com.example.masala.repository.BrandRepo;

@Service
public class BrandService {

    @Autowired
    private BrandRepo brandRepo;

    public Brand create(Brand brand) {
        return brandRepo.save(brand);
    }

    public List<Brand> getAllBrands() {
        return brandRepo.findAll();
    }

    public Brand getBrandId(int brand_id) {
        return brandRepo.findById(brand_id).orElse(null);
    }
    public List<Brand> getBrandName(String brand_name){
        return brandRepo.findByBrand_name(brand_name);
    }
    public Page <Brand> brandPagination(int offset,int pageSize){
        return brandRepo.findAll(PageRequest.of(offset,pageSize));
    }
    public List<Brand> brandSort(String field) {
        return brandRepo.findAll(Sort.by(Sort.Direction.ASC,field)); 
    }
    public Page<Brand> brandPaginationSort(int offset,int pageSize, String field) {
        return brandRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(Sort.Direction.ASC,field)));
    }
}
