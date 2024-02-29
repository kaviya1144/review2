package com.example.masala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.masala.model.Brand;
import java.util.List;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer> {

    @Query("Select b from Brand b where brand_name = :brand_name")
    List<Brand> findByBrand_name(String brand_name);
}
