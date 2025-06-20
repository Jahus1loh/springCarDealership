package com.example.elementsManagment.repository;

import com.example.category.entity.DealershipCategory;
import com.example.elementsManagment.entity.CarElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarElement, UUID> {

    Optional<CarElement> findByBrandName(String brandName);

    List<CarElement> findAllByDealership(DealershipCategory dealership);


    Optional<CarElement> findByid(UUID id);
}
