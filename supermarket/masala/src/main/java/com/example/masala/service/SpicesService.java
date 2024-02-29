package com.example.masala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masala.model.Spices;
import com.example.masala.repository.SpicesRepo;

import jakarta.transaction.Transactional;

@Service
public class SpicesService {

    @Autowired
    private SpicesRepo spicesRepo;

    public Spices createspice(Spices spices) {
        return spicesRepo.save(spices);
    }

    public List<Spices> getAllSpices() {
        return spicesRepo.findAll();
    }

    public Spices getSpiceId(int id) {
        return spicesRepo.findById(id).orElse(null);
    }

    @Transactional
    public void putSpices(int id, int price) {
        spicesRepo.updatePrice(id, price);
    }

}
