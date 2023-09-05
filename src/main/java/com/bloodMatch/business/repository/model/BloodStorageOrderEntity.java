package com.bloodMatch.business.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blood_storage_orders")
public class BloodStorageOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_info_id", nullable = false)
    private Long bloodInfoId;

    @Column(name = "patient_unique_number", nullable = false)
    String uniqueNumber;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderTime;

    @Column(name = "order_number", nullable = false, unique = true)
    private String orderNumber;
}
