package com.bloodMatch.business.repository;

import com.bloodMatch.business.repository.model.BloodStorageOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodStorageOrderRepository extends JpaRepository<BloodStorageOrderEntity, Long> {
}
