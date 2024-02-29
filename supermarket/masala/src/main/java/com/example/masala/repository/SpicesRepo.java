package com.example.masala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.masala.model.Spices;

@Repository
public interface SpicesRepo extends JpaRepository<Spices,Integer>{
    
    @Modifying
    @Query("update Spices spices set spices.price = ?2 where spices.id = ?1")
    void updatePrice(int id,int price);

}
