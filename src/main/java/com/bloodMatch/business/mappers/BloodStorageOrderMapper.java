package com.bloodMatch.business.mappers;

import com.bloodMatch.business.model.BloodStorageOrder;
import com.bloodMatch.business.repository.model.BloodStorageOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BloodStorageOrderMapper {
    @Mapping(source = "orderTime", target = "orderTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    BloodStorageOrderEntity bloodStorageOrderToBloodStorageOrderEntity(BloodStorageOrder bloodStorageOrder);
    BloodStorageOrder bloodStorageOrderEntityToBloodStorageOrder(BloodStorageOrderEntity bloodStorageOrderEntity);
}
