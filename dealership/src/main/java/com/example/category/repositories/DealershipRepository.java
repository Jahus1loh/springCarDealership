package com.example.category.repositories;

import com.example.category.entity.DealershipCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface DealershipRepository extends JpaRepository<DealershipCategory, UUID> {

    Optional<DealershipCategory> findByName(String name);

    Optional<DealershipCategory> findByid(UUID dealershipId);

    Optional<DealershipCategory> findById(UUID id);
}
