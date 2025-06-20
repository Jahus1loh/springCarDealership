package com.example.category.service;

import com.example.category.entity.DealershipCategory;
import com.example.category.repositories.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DealershipService {
    private final DealershipRepository dealershipRepository;

    @Autowired
    public DealershipService(DealershipRepository dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
    }

    public List<DealershipCategory> getAllDealerships() {
        return dealershipRepository.findAll();
    }

    public Optional<DealershipCategory> findByid(UUID dealershipId) {
        return dealershipRepository.findByid(dealershipId);
    }

    public List<DealershipCategory> findAll() {
        return dealershipRepository.findAll();
    }

    public List<DealershipCategory> findAllSorted(String sort) {
        return dealershipRepository.findAll(Sort.by(sort));
    }

    public boolean delete(UUID id) {
        Optional<DealershipCategory> dealership = dealershipRepository.findByid(id);

        if (dealership.isPresent()) {
            dealershipRepository.delete(dealership.get());
            return true;
        } else {
            return false;
        }
    }

    public DealershipCategory save(DealershipCategory dealershipCategory) {
        return dealershipRepository.save(dealershipCategory);
    }

    public Optional<DealershipCategory> findById(UUID id) {
        return dealershipRepository.findById(id);
    }

    public void create(DealershipCategory dealershipCategory) {
        dealershipRepository.save(dealershipCategory);
    }

}
